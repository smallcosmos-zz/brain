package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.EduLevel;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.service.EduLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/edu")
public class EduLevelController {
    @Autowired
    private EduLevelService eduLevelService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public ResultVO<List<EduLevel>> getAllEduLevel(){
        List<EduLevel> eduLevels = eduLevelService.selectAll();
        ResultVO ret = ResultVO.fail();
        if(null != eduLevels && eduLevels.size() > 0){
            ret = ResultVO.success(eduLevels);
        }
        return ret;
    }
}
