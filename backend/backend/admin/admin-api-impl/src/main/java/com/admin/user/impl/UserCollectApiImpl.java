package com.admin.user.impl;

import com.admin.user.api.UserCollectApi;
import com.admin.user.dto.usercollect.UserCollectMusicSaveDTO;
import com.admin.user.entity.po.UserCollectMusic;
import com.admin.user.repository.base.example.UserCollectMusicExample;
import com.admin.user.repository.base.service.UserCollectMusicService;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(value = "UserCollectApi", description = "用户收藏管理")
@RestController
@RequestMapping("/collect")
public class UserCollectApiImpl implements UserCollectApi{
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private UserCollectMusicService userCollectMusicService;

    @Override
    @ApiOperation(value = "添加收藏音乐", notes = "添加收藏音乐")
    @RequestMapping(value = "/saveCollectMusic", method = RequestMethod.POST)
    public Result<Boolean> saveCollectMusic(@RequestBody UserCollectMusicSaveDTO dto) {
        Long userId = BaseContextHandler.getAdminId();

        UserCollectMusicExample example = new UserCollectMusicExample();
        example.createCriteria().andUserIdEqualTo(userId).andMusicIdEqualTo(dto.getMusicId());
        if(userCollectMusicService.find(example).size()>0){
            return Result.fail("你已经收藏过该音乐！");
        }

        UserCollectMusic userCollectMusic = dozerUtils.map(dto,UserCollectMusic.class);
        userCollectMusic.setCreateUser(userId);
        userCollectMusic.setUpdateUser(userId);
        userCollectMusic.setUserId(userId);

        if (userCollectMusicService.save(userCollectMusic) != null){
            return Result.success(true);
        }
        return Result.fail("添加失败！");
    }

    @Override
    @IgnoreToken
    @ApiOperation(value = "获取收藏音乐", notes = "获取收藏音乐")
    @RequestMapping(value = "/getCollectMusic", method = RequestMethod.GET)
    public Result<List<UserCollectMusicSaveDTO>> getCollectMusic(@RequestParam(value = "userId") Long userId) {
        UserCollectMusicExample example = new UserCollectMusicExample();
        example.createCriteria().andUserIdEqualTo(userId);

        List list = userCollectMusicService.find(example);
        if (list.size()>0){
            return Result.success(dozerUtils.mapList(list,UserCollectMusicSaveDTO.class));
        }

        return Result.success(list);
    }

    @Override
    @ApiOperation(value = "取消收藏音乐", notes = "取消收藏音乐")
    @RequestMapping(value = "/deleteCollectMusic",method = RequestMethod.GET)
    public Result<Boolean> deleteCollectMusic(@RequestParam(value = "musicId") Long musicId) {
        Long userId = BaseContextHandler.getAdminId();

        UserCollectMusicExample example = new UserCollectMusicExample();
        example.createCriteria().andUserIdEqualTo(userId).andMusicIdEqualTo(musicId);

        List<UserCollectMusic> list = userCollectMusicService.find(example);
        if (userCollectMusicService.deleteByIds(list.stream().map(UserCollectMusic::getId).collect(Collectors.toList()))>0){
            return Result.success(true);
        }
        return Result.fail("取消收藏失败！");
    }
}
