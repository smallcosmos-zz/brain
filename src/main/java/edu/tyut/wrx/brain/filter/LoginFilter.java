package edu.tyut.wrx.brain.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import edu.tyut.wrx.brain.model.Admin;
import edu.tyut.wrx.brain.model.Organization;
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
        response.setContentType("application/json; charset=utf-8");
        JSONObject retJsonObj = null;
        //校验机构是否登录
        Organization orgBySessionId = BrainUtils.getOrgBySessionId(request);
        if(null == orgBySessionId){
            retJsonObj = LoginFilter.getRetJsonObj("300", "当前机构账号未登录");
            response.getWriter().println(retJsonObj);
            return false;
        }
        //这两个请求只需要机构登录不需要用户提交信息
        if(request.getRequestURI().equals("/edu/queryAll")){
            return true;
        }
        if(request.getRequestURI().startsWith("/record")) {
            Admin adminBySessionId = BrainUtils.getAdminBySessionId(request);
            if(null == adminBySessionId) {
                retJsonObj = LoginFilter.getRetJsonObj("300", "admin未登录");
                response.getWriter().println(retJsonObj);
                return false;
            }
            return true;
        }
        //验证用户是否提交信息
        User userBySessionId = BrainUtils.getUserBySessionId(request);
        if (null == userBySessionId) {
            retJsonObj = LoginFilter.getRetJsonObj("300", "当前用户未提交信息");
            response.getWriter().println(retJsonObj);
            return false;
        }
        return true;
    }

    private static JSONObject getRetJsonObj(String code,String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put(code,msg);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }
}
