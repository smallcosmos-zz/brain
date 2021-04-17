package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.Organization;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 机构相关操作类
 */
@Controller
@RequestMapping("/organization/*")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    /**
     * 登录接口
     * @param organization
     * @return
     */
    @RequestMapping( value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO orgLogin(Organization organization, HttpServletRequest request, HttpServletResponse response) {
        ResultVO resultVO = organizationService.orgLogin(organization,request,response);

        return resultVO;
    }
}
