package edu.tyut.wrx.brain.service;

import edu.tyut.wrx.brain.model.RecordDTO;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.model.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {
    ResultVO insertUser(User user, HttpServletRequest request, HttpServletResponse response);
}
