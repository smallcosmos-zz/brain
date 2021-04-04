package edu.tyut.wrx.brain.service;

import edu.tyut.wrx.brain.model.Organization;
import edu.tyut.wrx.brain.model.ResultVO;

public interface OrganizationService {
    ResultVO orgLogin(Organization organization);
}
