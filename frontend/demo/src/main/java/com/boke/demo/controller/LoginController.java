package com.boke.demo.controller;

import com.admin.user.api.UserApi;
import com.admin.user.dto.UserResDTO;
import com.boke.demo.config.BokeWebappConfig;
import com.boke.demo.security.LoginInfoUtil;
import com.google.common.base.Strings;
import com.hengyunsoft.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;

@Controller
@RequestMapping("login")
public class LoginController {

    private final static int EXPIRE_SECONDS = 2 * 24 * 3600;
    @Autowired
    private UserApi userApi;

    @Autowired
    private BokeWebappConfig bokeWebappConfig;

    public LoginController() {

    }

    protected void loginSuccess(String id, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //查用户身份
        Result<UserResDTO> result = userApi.get(Long.valueOf(id));
        UserResDTO loginUserInfo = result.getData();
        LoginInfoUtil.addLoginUser(loginUserInfo, request, response);

//        //获取token
//        String token = TokenCache.of(gxqptWebappConfig.getAppId(), gxqptWebappConfig.getAppSecret()).get().get();

//        setTokenCookie(token, response);
        setCpCookie(request, response);
        setUserIdCookie(loginUserInfo.getId(), response);
        setUserNameCookie(loginUserInfo.getNickname(), response);
//        setLoginUrlCookie(gxqptWebappConfig.getLoginUrl(), response);
        response.sendRedirect(bokeWebappConfig.getIndexUrl());

    }

    private void setCpCookie(HttpServletRequest request,  HttpServletResponse response) {
        Cookie cpCookie = new Cookie("_cp",  request.getContextPath());
        cpCookie.setPath("/");
        cpCookie.setSecure(false);
        response.addCookie(cpCookie);
    }

    private void setTokenCookie(String token, HttpServletResponse response) {
        token = token.replace("+", "%20");
        Cookie tokenCookie = new Cookie("_token", token);
        tokenCookie.setPath("/");
        tokenCookie.setSecure(false);
        response.addCookie(tokenCookie);
    }
    private void setUserIdCookie(Long userId, HttpServletResponse response) {
        Cookie userCookie = new Cookie("_user_id", String.valueOf(userId));
        userCookie.setPath("/");
        userCookie.setSecure(false);
        userCookie.setMaxAge(EXPIRE_SECONDS);
        response.addCookie(userCookie);
    }
    private void setUserNameCookie(String userName, HttpServletResponse response) {
        try{
            if(!Strings.isNullOrEmpty(userName)){
                Cookie userNameCookie = new Cookie("_user_name", URLEncoder.encode(userName, "UTF-8"));
                userNameCookie.setPath("/");
                userNameCookie.setSecure(false);
                userNameCookie.setMaxAge(EXPIRE_SECONDS);
                response.addCookie(userNameCookie);
            }
        }catch (Exception e){

        }
    }
    private void setLoginUrlCookie(String loginUrl, HttpServletResponse response) {
        Cookie tokenCookie = new Cookie("_loginUrl", loginUrl);
        tokenCookie.setPath("/");
        tokenCookie.setSecure(false);
        tokenCookie.setMaxAge(EXPIRE_SECONDS);
        response.addCookie(tokenCookie);
    }

    @RequestMapping("validate")
    public void validate(String id, HttpServletRequest request, HttpServletResponse response)
            throws IOException, URISyntaxException, ServletException {
        // TODO Auto-generated method stub
        loginSuccess(id, request, response);
    }

    @RequestMapping("index")
    public String index(Model model)
            throws IOException, URISyntaxException, ServletException {
        // TODO Auto-generated method stub
        return "login";
    }
}
