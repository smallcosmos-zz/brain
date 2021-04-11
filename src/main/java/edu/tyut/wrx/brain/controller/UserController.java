package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.model.User;
import edu.tyut.wrx.brain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO addUser(User user, HttpServletRequest request, HttpServletResponse response) {
        ResultVO resultVO = userService.insertUser(user,request,response);
        return resultVO;
    }
}
