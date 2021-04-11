package edu.tyut.wrx.brain.controller;

import edu.tyut.wrx.brain.model.Organization;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ResultVO orgLogin(Organization organization) {
        ResultVO resultVO = organizationService.orgLogin(organization);
        System.out.println(resultVO);
        return resultVO;
    }
}
