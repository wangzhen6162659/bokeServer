package com.admin.user.api;

import com.admin.user.dto.user.UserLoginDTO;
import com.admin.user.dto.user.UserLoginResDTO;
import com.admin.user.dto.user.UserResDTO;
import com.admin.user.dto.user.UserSaveDTO;
import com.admin.user.dto.user.UserUpdateDTO;
import com.hengyunsoft.base.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@FeignClient(name = "${boke.feign.auth-server:admin-server}")
public interface UserApi {
    @RequestMapping(value = "/user/get",method = RequestMethod.GET)
    Result<UserResDTO> get(@RequestParam(value = "id") Long id);

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    Result<UserLoginResDTO> update(@RequestBody UserUpdateDTO dto) throws UnsupportedEncodingException;

    @RequestMapping(value = "/user/save",method = RequestMethod.POST)
    Result<UserResDTO> save(@RequestBody UserSaveDTO dto) throws UnsupportedEncodingException;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    Result<UserLoginResDTO> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request, HttpServletResponse response) throws IOException;
}
