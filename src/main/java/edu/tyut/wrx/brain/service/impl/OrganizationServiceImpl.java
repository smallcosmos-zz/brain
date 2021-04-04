package edu.tyut.wrx.brain.service.impl;

import edu.tyut.wrx.brain.dao.OrganizationMapper;
import edu.tyut.wrx.brain.model.Organization;
import edu.tyut.wrx.brain.model.ResultCode;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;
    @Override
    public ResultVO orgLogin(Organization organization) {
        //进行数据校验
        if(null == organization.getOrgName() || organization.getOrgName().trim().length() == 0) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"机构名称不能为空");
        }
        if(null == organization.getOrgPwd() || organization.getOrgPwd().trim().length() == 0) {
            return ResultVO.fail(ResultCode.VALIDATION_FAILD_CODE,"登录密码不能为空");
        }
        Organization dbOrganization = organizationMapper.orgLogin(organization);
        if(null == dbOrganization) {
            return ResultVO.fail("机构名称或密码有误");
        }
        return ResultVO.success();
    }
}
