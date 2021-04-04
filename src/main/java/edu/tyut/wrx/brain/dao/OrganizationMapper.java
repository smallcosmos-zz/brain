package edu.tyut.wrx.brain.dao;

import edu.tyut.wrx.brain.model.Organization;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrganizationMapper {
    Organization orgLogin(Organization organization);
}
