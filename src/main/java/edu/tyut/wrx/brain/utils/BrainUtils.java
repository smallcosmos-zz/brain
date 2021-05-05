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

    private static final String USER_SESSIONID = "USERSESSIONID";
    private static final String ORG_SESSIONID = "ORGSESSIONID";
    private static final String ADMIN_SESSIONID = "ADMINSESSIONID";

    public static User getUserBySessionId(HttpServletRequest request) {
        return (User)getObjFromCookies(USER_SESSIONID, request);
    }

    public static Organization getOrgBySessionId(HttpServletRequest request) {
        return (Organization) getObjFromCookies(ORG_SESSIONID,request);
    }

    public static Admin getAdminBySessionId(HttpServletRequest request) {
        return (Admin)getObjFromCookies(ADMIN_SESSIONID,request);
    }

    public static Object getObjFromCookies(String sessionId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object obj = null;
        Cookie[] cookies = request.getCookies();
        if(null == cookies || cookies.length == 0) {
            return obj;
        }
        for(Cookie cookie: cookies) {
            if(sessionId.equals(cookie.getName())){
                obj =  session.getAttribute(cookie.getValue());
            }
        }
        return obj;
    }
}
