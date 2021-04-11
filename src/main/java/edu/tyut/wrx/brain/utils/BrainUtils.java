package edu.tyut.wrx.brain.utils;

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
}
