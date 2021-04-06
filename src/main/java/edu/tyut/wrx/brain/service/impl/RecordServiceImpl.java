package edu.tyut.wrx.brain.service.impl;

import edu.tyut.wrx.brain.dao.RecordMapper;
import edu.tyut.wrx.brain.model.Record;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;
    @Override
    public ResultVO addRecordToDb(Record record) {
        if(null == record.getUserId() || StringUtils.isEmpty(record.getUserId().trim())) {
            return ResultVO.fail("就诊卡号不能为空");
        }
        if(null == record.getOrgId()) {
            return ResultVO.fail("机构id不能空");
        }
        if(null == record.getGameId()) {
            return ResultVO.fail("游戏id不能为空");
        }
        if(null == record.getStartTime()) {
            return ResultVO.fail("游戏开始时间不能为空");
        }
        if(null == record.getEndTime()) {
            return ResultVO.fail("游戏结束时间不能为空");
        }
        if(null == record.getScore()) {
            return ResultVO.fail("游戏得分不能为空");
        }
        recordMapper.insertRecord(record);
        if(null == record.getId()){
            return ResultVO.fail("插入游戏记录失败");
        }
        return ResultVO.success();
    }
}
