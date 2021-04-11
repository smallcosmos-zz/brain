package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.Record;
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

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;

    @RequestMapping(value = "/addRecord",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO addRecord(Record record, HttpServletRequest request) {
        //进行登录校验
        User currentUser = BrainUtils.getUserBySessionId(request);
        if(null == currentUser) {
            return ResultVO.fail("当前用户未登录");
        }
        ResultVO resultVO = recordService.addRecordToDb(record);
        return resultVO;
    }
}
