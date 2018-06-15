package com.admin.user.impl;

import com.admin.user.api.UserApi;
import com.admin.user.dto.UserResDTO;
import com.admin.user.entity.po.User;
import com.admin.user.repository.base.example.UserExample;
import com.admin.user.repository.base.service.UserService;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Api(value = "UserApi", description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserApiImpl implements UserApi {
    @Autowired
    UserService userService;
    @Autowired
    DozerUtils dozerUtils;

    @Override
    @ApiOperation(value="查找用户", notes="查找用户")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<UserResDTO> get(@RequestParam(value = "id") Long id) {
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo((long)1);
        User user = userService.getUnique(example);
        return Result.success(dozerUtils.map(user,UserResDTO.class));
    }
}
