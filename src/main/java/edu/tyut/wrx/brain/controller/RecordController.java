package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.Record;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;

    @RequestMapping(value = "/addRecord",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO addRecord(Record record) {
        ResultVO resultVO = recordService.addRecordToDb(record);
        return resultVO;
    }
}
