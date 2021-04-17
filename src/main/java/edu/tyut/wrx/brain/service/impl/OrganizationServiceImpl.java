package edu.tyut.wrx.brain.service.impl;

import edu.tyut.wrx.brain.dao.OrganizationMapper;
import edu.tyut.wrx.brain.model.Organization;
import edu.tyut.wrx.brain.model.ResultCode;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;
    @Override
    public ResultVO orgLogin(Organization organization, HttpServletRequest request, HttpServletResponse response) {
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
        HttpSession session = request.getSession();
        String sessionId = UUID.randomUUID().toString().toLowerCase().replace("-","");
        session.setAttribute(sessionId,dbOrganization);
        Cookie sessionid = new Cookie("ORGSESSIONID", sessionId);
        sessionid.setMaxAge(60*60);
        sessionid.setPath("/");
        response.addCookie(sessionid);
        return ResultVO.success();
    }
}
