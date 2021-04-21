package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.Organization;
import edu.tyut.wrx.brain.model.Record;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.model.User;
import edu.tyut.wrx.brain.service.UserService;
import edu.tyut.wrx.brain.utils.BrainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecordController recordController;

    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO addUser(User user, HttpServletRequest request, HttpServletResponse response) {
        ResultVO resultVO = userService.insertUser(user,request,response);
        if(resultVO.getCode() == 200) {
            String userBySessionId = user.getId();
            Integer orgBySessionId = BrainUtils.getOrgBySessionId(request).getId();
            Date startTime = new Date();
            Date endTime = new Date();
            Record record1 = new Record(userBySessionId,orgBySessionId,1,startTime,endTime,0);
            Record record2 = new Record(userBySessionId,orgBySessionId,2,startTime,endTime,0);
            Record record3 = new Record(userBySessionId,orgBySessionId,3,startTime,endTime,0);
            recordController.addRecord(record1,request);
            recordController.addRecord(record2,request);
            recordController.addRecord(record3,request);
        }
        return resultVO;
    }
}
