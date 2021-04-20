package edu.tyut.wrx.brain.service;

import edu.tyut.wrx.brain.model.Admin;

public interface AdminService {
    Admin selectAdmin(String password);
}
