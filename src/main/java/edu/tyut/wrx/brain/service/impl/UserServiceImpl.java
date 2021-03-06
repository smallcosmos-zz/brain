package edu.tyut.wrx.brain.service.impl;

import edu.tyut.wrx.brain.dao.UserMapper;
import edu.tyut.wrx.brain.model.ResultCode;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.model.User;
import edu.tyut.wrx.brain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultVO insertUser(User user, HttpServletRequest request, HttpServletResponse response) {
        //校验字段是否为空
        if(null == user.getId() || user.getId().trim().length() == 0){
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"就诊卡号不能为空");
        }
        if(null == user.getUserName() || user.getUserName().trim().length() == 0) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"患者姓名不能为空");
        }
        if(null == user.getUserGender()) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"患者性别不能为空");
        }
        if(null == user.getUserAge()) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"患者年龄不能为空");
        }
        if(null == user.getUserEduLevel() || user.getUserEduLevel() < 0 || user.getUserEduLevel() > 8){
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"教育水平校验失败");
        }
        if(user.getUserAge() < 0 || user.getUserAge() > 120) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"患者年龄范围不正确");
        }
        try {
            userMapper.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof DuplicateKeyException) {
                return ResultVO.fail("就诊卡号不能重复");
            }
            return ResultVO.fail("插入用户信息失败");
        }
        HttpSession session = request.getSession();
        String sessionId = UUID.randomUUID().toString().toLowerCase().replace("-","");
        session.setAttribute(sessionId,user);
        Cookie sessionid = new Cookie("USERSESSIONID", sessionId);
        sessionid.setMaxAge(60*60);
        sessionid.setPath("/");
        response.addCookie(sessionid);
        return ResultVO.success();
    }
}
