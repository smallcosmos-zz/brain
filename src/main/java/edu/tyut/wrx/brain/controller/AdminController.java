package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.Admin;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public ResultVO adminLogin(String password, HttpServletRequest request, HttpServletResponse response) {
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
        HttpSession session = request.getSession();
        String sessionId = UUID.randomUUID().toString().toLowerCase().replace("-","");
        session.setAttribute(sessionId,admin);
        Cookie sessionid = new Cookie("ADMINSESSIONID", sessionId);
        sessionid.setMaxAge(20*60);
        sessionid.setPath("/");
        response.addCookie(sessionid);
        return ResultVO.success();
    }
}
