package com.boke.demo.interceptor;

import com.admin.user.dto.UserResDTO;
import com.boke.demo.security.LoginInfoUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenSetInterceptor extends HandlerInterceptorAdapter{
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        try {
            UserResDTO loginUser = LoginInfoUtil.getLoginUser(request);
            if (loginUser != null) {
//                    request.setAttribute("_token", tokenVal);
                    request.setAttribute("_user_id", 1);
                    request.setAttribute("_user_name", loginUser.getName());

                    Cookie userCookie = new Cookie("_user_id", String.valueOf(loginUser.getId()));
                    userCookie.setPath("/");
                    userCookie.setSecure(false);
                    response.addCookie(userCookie);

                    //Cookie userNameCookie = new Cookie("_user_name", String.valueOf(loginUser.getName()));
                    //userNameCookie.setPath("/");
                    //userNameCookie.setSecure(false);
                    //userNameCookie.setMaxAge(EXPIRE_SECONDS);
                    //response.addCookie(userNameCookie);
                }
        } catch (Exception e) {

        }
    }
}
