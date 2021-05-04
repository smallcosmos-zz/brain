package edu.tyut.wrx.brain.service.impl;

import edu.tyut.wrx.brain.dao.RecordMapper;
import edu.tyut.wrx.brain.model.*;
import edu.tyut.wrx.brain.service.RecordService;
import edu.tyut.wrx.brain.utils.BrainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    /**
     * 添加游戏记录到数据库，如果该患者中途退出，再次上线重新做，就会删除之前的记录，从新进行插入
     * @param record
     * @return
     */
    @Override
    public ResultVO addRecordToDb(Record record) {
        if(null == record.getUserId() || StringUtils.isEmpty(record.getUserId().trim())) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"就诊卡号不能为空");
        }
        if(null == record.getOrgId()) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"机构id不能空");
        }
        if(null == record.getGameId()) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"游戏id不能为空");
        }
        if(null == record.getStartTime()) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"游戏开始时间不能为空");
        }
        if(null == record.getEndTime()) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"游戏结束时间不能为空");
        }
        if(null == record.getScore()) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"游戏得分不能为空");
        }
        //插入之前进行校验，如果已经存在该患者的这个游戏记录则先进行删除
        synchronized (this) {
            Record dbRecord = recordMapper.selectRecord(record);
            if(null != dbRecord){
                recordMapper.deleteRecord(dbRecord);
            }
            //插入游戏记录
            recordMapper.insertRecord(record);
        }
        if(null == record.getId()){
            return ResultVO.fail("插入游戏记录失败");
        }
        return ResultVO.success();
    }

    @Override
    public List<RecordDTO> getAllRecord(HttpServletRequest request) {
        Organization orgBySessionId = BrainUtils.getOrgBySessionId(request);
        List<RecordDTO> allRecord = recordMapper.getAllRecord(orgBySessionId.getId());
        if(allRecord != null && allRecord.size() > 0) {
            for (RecordDTO r : allRecord) {
                List<gameAndScore> gameAndScores = recordMapper.getGameAndScoreByUserId(r.getUser().getId());
                r.setGameAndScores(gameAndScores);
                Date gameDate = r.getGameDate();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = dateFormat.format(gameDate);
                r.setGameDateStr(format);
            }
        }

        return allRecord;
    }

    @Override
    public RecordDTO getRecordByUserId(String userId, HttpServletRequest request) {
        Organization orgBySessionId = BrainUtils.getOrgBySessionId(request);
        RecordDTO recordDTO = recordMapper.getRecordByUserId(userId,orgBySessionId.getId());
        if(recordDTO != null) {
            List<gameAndScore> gameAndScoreByUserId = recordMapper.getGameAndScoreByUserId(recordDTO.getUser().getId());
            recordDTO.setGameAndScores(gameAndScoreByUserId);
            Date gameDate = recordDTO.getGameDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = dateFormat.format(gameDate);
            recordDTO.setGameDateStr(format);
        }
        return recordDTO;
    }
}
