package edu.tyut.wrx.brain.service.impl;

import edu.tyut.wrx.brain.dao.UserMapper;
import edu.tyut.wrx.brain.model.ResultCode;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.model.User;
import edu.tyut.wrx.brain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultVO insertUser(User user) {
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
        try {
            userMapper.insertUser(user);
            return ResultVO.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.fail("插入用户信息失败");
        }
    }
}
