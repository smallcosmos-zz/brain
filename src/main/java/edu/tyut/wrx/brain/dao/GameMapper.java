package edu.tyut.wrx.brain.dao;

import edu.tyut.wrx.brain.model.Game;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GameMapper {

    Game getGameByName(@Param("gameName") String gameName);
}
