package edu.tyut.wrx.brain.dao;

import edu.tyut.wrx.brain.model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    Admin selectAdmin(String password);
}
