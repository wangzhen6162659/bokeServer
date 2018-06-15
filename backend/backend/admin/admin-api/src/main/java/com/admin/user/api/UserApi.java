package com.admin.user.api;

import com.admin.user.dto.UserResDTO;
import com.hengyunsoft.base.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${boke.feign.auth-server:admin-server}")
public interface UserApi {
    @RequestMapping(value = "/user/get",method = RequestMethod.GET)
    Result<UserResDTO> get(@RequestParam(value = "id") Long id);
}
