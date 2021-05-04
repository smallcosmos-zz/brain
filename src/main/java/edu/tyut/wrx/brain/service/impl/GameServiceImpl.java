package edu.tyut.wrx.brain.service.impl;

import edu.tyut.wrx.brain.dao.GameMapper;
import edu.tyut.wrx.brain.model.Game;
import edu.tyut.wrx.brain.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameMapper gameMapper;

    @Override
    public Game getGameByName(String gameName) {
        Game game = gameMapper.getGameByName(gameName);
        return game;
    }
}
