package edu.tyut.wrx.brain.service.impl;

import edu.tyut.wrx.brain.dao.EduLevelMapper;
import edu.tyut.wrx.brain.model.EduLevel;
import edu.tyut.wrx.brain.service.EduLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduLevelServiceImpl implements EduLevelService {
    @Autowired
    EduLevelMapper eduLevelMapper;
    @Override
    public List<EduLevel> selectAll() {
        return eduLevelMapper.selectAll();
    }
}
