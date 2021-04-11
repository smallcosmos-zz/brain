package edu.tyut.wrx.brain.service;

import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    ResultVO insertUser(User user, HttpServletRequest request, HttpServletResponse response);
}
