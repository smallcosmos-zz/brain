package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.Game;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/getGameByName")
    @ResponseBody
    public ResultVO getGameByName(String gameName) {
        if(null == gameName || gameName.trim().equals("")) {
            return ResultVO.fail("游戏名称不能为空");
        }
        Game game = gameService.getGameByName(gameName);
        if(game == null) {
            return ResultVO.fail("根据游戏名称查询游戏失败");
        }
        return ResultVO.success(game);
    }
}
