package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.Record;
import edu.tyut.wrx.brain.model.RecordDTO;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.model.User;
import edu.tyut.wrx.brain.service.RecordService;
import edu.tyut.wrx.brain.utils.BrainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;

    @RequestMapping(value = "/addRecord",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO addRecord(Record record, HttpServletRequest request) {
        record.setUserId(BrainUtils.getUserBySessionId(request).getId());
        record.setOrgId(BrainUtils.getOrgBySessionId(request).getId());
        ResultVO resultVO = recordService.addRecordToDb(record);
        return resultVO;
    }
    
    @RequestMapping("/getAllRecord")
    @ResponseBody
    public ResultVO getAllRecord(HttpServletRequest request) {
        List<RecordDTO> allRecord = recordService.getAllRecord(request);
        ResultVO ret = ResultVO.fail("未查询到记录");
        if(allRecord != null) {
            ret = ResultVO.success(allRecord);
        }
        return ret;
    }
}
