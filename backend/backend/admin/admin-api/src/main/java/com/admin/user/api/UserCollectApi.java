package com.admin.user.api;

import com.admin.user.dto.usercollect.UserCollectMusicSaveDTO;
import com.hengyunsoft.base.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${boke.feign.auth-server:admin-server}")
public interface UserCollectApi {
    @RequestMapping(value = "/collect/saveCollectMusic",method = RequestMethod.POST)
    Result<Boolean> saveCollectMusic(@RequestBody UserCollectMusicSaveDTO dto);

    @RequestMapping(value = "/collect/getCollectMusic",method = RequestMethod.GET)
    Result<List<UserCollectMusicSaveDTO>> getCollectMusic(@RequestParam(value = "userId") Long userId);

    @RequestMapping(value = "/collect/deleteCollectMusic",method = RequestMethod.GET)
    Result<Boolean> deleteCollectMusic(@RequestParam(value = "musicId") Long musicId);
}
