package edu.tyut.wrx.brain.service.impl;

import edu.tyut.wrx.brain.dao.AdminMapper;
import edu.tyut.wrx.brain.model.Admin;
import edu.tyut.wrx.brain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin selectAdmin(String password) {
        return adminMapper.selectAdmin(password);
    }
}
