package edu.tyut.wrx.brain.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.tyut.wrx.brain.model.ResultVO;
import edu.tyut.wrx.brain.model.User;
import edu.tyut.wrx.brain.utils.BrainUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User userBySessionId = BrainUtils.getUserBySessionId(request);
        if(null != userBySessionId) {
            return true;
        }
        response.setContentType("application/json; charset=utf-8");
        Map<String, Object> map = new HashMap<>();
        map.put("300","当前用户未登录");
        JSONObject jsonObject = new JSONObject(map);
        response.getWriter().println(jsonObject);
        return false;
    }
}
