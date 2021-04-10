package edu.tyut.wrx.brain.service;

import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.model.User;

public interface UserService {
    ResultVO insertUser(User user);
}
