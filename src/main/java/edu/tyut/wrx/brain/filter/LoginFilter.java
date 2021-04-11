package edu.tyut.wrx.brain.filter;

import edu.tyut.wrx.brain.model.User;
import edu.tyut.wrx.brain.utils.BrainUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User userBySessionId = BrainUtils.getUserBySessionId(request);
        if(null != userBySessionId) {
            return true;
        }
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("用户未登录");
        return false;
    }
}
