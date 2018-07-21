//package com.hengyunsoft.security.auth.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.security.auth.dto.UserDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@FeignClient(name = "${gxqpt.feign.auth-server:gxqpt-auth-server}")
//public abstract class UserApi {
//
//    @RequestMapping(value = "/user/getById")
//    public abstract Result<UserDTO> getById(@RequestParam(value = "id") Long id);
//
//    @RequestMapping(value = "/user/getByAccount")
//    public abstract Result<UserDTO> getByAccount(@RequestParam(value = "account") String account);
//}
