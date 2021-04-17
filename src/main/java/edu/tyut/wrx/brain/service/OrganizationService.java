package edu.tyut.wrx.brain.service;

import edu.tyut.wrx.brain.model.Organization;
import edu.tyut.wrx.brain.model.ResultVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OrganizationService {
    ResultVO orgLogin(Organization organization, HttpServletRequest request, HttpServletResponse response);
}
