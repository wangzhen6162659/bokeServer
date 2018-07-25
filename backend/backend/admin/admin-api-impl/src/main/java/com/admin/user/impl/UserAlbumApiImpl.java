package com.admin.user.impl;

import com.admin.user.api.UserAlbumApi;
import com.admin.user.dto.user.UserAlbumHomeResDTO;
import com.admin.user.entity.po.UserAlbum;
import com.admin.user.repository.base.example.UserAlbumExample;
import com.admin.user.repository.base.service.UserAlbumService;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(value = "UserApi", description = "心情照片管理")
@RestController
@RequestMapping("/album")
public class UserAlbumApiImpl implements UserAlbumApi{
    @Autowired
    UserAlbumService userAlbumService;
    @Autowired
    DozerUtils dozerUtils;

    @Override
    @ApiOperation(value="查找用户照片", notes="查找用户照片")
    @IgnoreToken
    @RequestMapping(value = "/findPicture", method = RequestMethod.GET)
    public Result<List<UserAlbumHomeResDTO>> findPicture() {
        UserAlbumExample example = new UserAlbumExample();
        example.createCriteria().andUserIdEqualTo((long)1);
        List list = userAlbumService.find(example);
        return Result.success(dozerUtils.mapList(list,UserAlbumHomeResDTO.class));
    }

    @Override
    @ApiOperation(value="照片切换", notes="照片切换")
    @IgnoreToken
    @RequestMapping(value = "/getByIndex", method = RequestMethod.GET)
    public Result<UserAlbumHomeResDTO> getByIndex(@RequestParam(value = "index") Long index) {
        Long id = 1L;

        UserAlbum res = userAlbumService.getByIndex(id,index);

        return Result.success(dozerUtils.map(res,UserAlbumHomeResDTO.class));
    }
}
