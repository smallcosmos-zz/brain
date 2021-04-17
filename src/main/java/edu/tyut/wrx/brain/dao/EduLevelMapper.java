package edu.tyut.wrx.brain.dao;

import edu.tyut.wrx.brain.model.EduLevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduLevelMapper {
    List<EduLevel> selectAll();
}
