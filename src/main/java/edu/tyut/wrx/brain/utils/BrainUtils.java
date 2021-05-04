package edu.tyut.wrx.brain.utils;

import edu.tyut.wrx.brain.model.Admin;
import edu.tyut.wrx.brain.model.Organization;
import edu.tyut.wrx.brain.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 系统工具类
 */
public class BrainUtils {

    public static User getUserBySessionId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = null;
        Cookie[] cookies = request.getCookies();
        if(null == cookies || cookies.length == 0) {
            return user;
        }
        else{
            for(Cookie cookie: cookies) {
                if("USERSESSIONID".equals(cookie.getName())){
                    user = (User) session.getAttribute(cookie.getValue());
                }
            }
        }
        return user;
    }

    public static Organization getOrgBySessionId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Organization org = null;
        Cookie[] cookies = request.getCookies();
        if(null == cookies || cookies.length == 0) {
            return org;
        }
        else{
            for(Cookie cookie: cookies) {
                if("ORGSESSIONID".equals(cookie.getName())){
                    org = (Organization) session.getAttribute(cookie.getValue());
                }
            }
        }
        return org;
    }

    public static Admin getAdminBySessionId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = null;
        Cookie[] cookies = request.getCookies();
        if(null == cookies || cookies.length == 0) {
            return admin;
        }
        else{
            for(Cookie cookie: cookies) {
                if("ADMINSESSIONID".equals(cookie.getName())){
                    admin = (Admin) session.getAttribute(cookie.getValue());
                }
            }
        }
        return admin;
    }
}
