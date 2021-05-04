package edu.tyut.wrx.brain.service;

import edu.tyut.wrx.brain.model.Game;

public interface GameService {

    Game getGameByName(String gameName);
}
