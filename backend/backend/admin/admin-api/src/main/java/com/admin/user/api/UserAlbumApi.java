package com.admin.user.api;

import com.admin.user.dto.user.UserAlbumHomeResDTO;
import com.hengyunsoft.base.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${boke.feign.auth-server:admin-server}")
public interface UserAlbumApi {
    @RequestMapping(value = "/user/findPicture",method = RequestMethod.GET)
    Result<List<UserAlbumHomeResDTO>> findPicture();

    @RequestMapping(value = "/article/getByIndex",method = RequestMethod.GET)
    Result<UserAlbumHomeResDTO> getByIndex(@RequestParam(value = "index") Long index);
}
