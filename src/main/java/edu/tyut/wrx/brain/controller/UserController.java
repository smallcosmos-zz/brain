package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.model.User;
import edu.tyut.wrx.brain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("addUser")
    @ResponseBody
    public ResultVO addUser(User user) {
        ResultVO resultVO = userService.insertUser(user);
        return resultVO;
    }
}
