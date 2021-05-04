package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.*;
import edu.tyut.wrx.brain.service.AdminService;
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

    @Autowired
    AdminService adminService;

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
    public ResultVO getAllRecord(String password,HttpServletRequest request) {
        ResultVO ret = null;
        if(null == password || password.trim().equals("")) {
            ret = ResultVO.fail("二级密码不能为空");
            return ret;
        }
        //先判断密码是否正确在进行查询数据
        Admin admin = adminService.selectAdmin(password);
        if(admin == null) {
            ret = ResultVO.fail("二级密码不正确");
            return ret;
        }
        List<RecordDTO> allRecord = recordService.getAllRecord(request);
        ret = ResultVO.fail("未查询到记录");
        if(allRecord != null) {
            ret = ResultVO.success(allRecord);
        }
        return ret;
    }

    @RequestMapping("/getRecordByUserId")
    @ResponseBody
    public ResultVO getRecordByUserId(String userId, HttpServletRequest request) {
        ResultVO ret = ResultVO.fail();
        RecordDTO record = recordService.getRecordByUserId(userId, request);
        if(record != null) {
            ret = ResultVO.success(record);
        }
        return ret;
    }
}
