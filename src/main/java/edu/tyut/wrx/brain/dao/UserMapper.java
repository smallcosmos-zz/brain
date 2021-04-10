package edu.tyut.wrx.brain.dao;

import edu.tyut.wrx.brain.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insertUser(User user);
}
