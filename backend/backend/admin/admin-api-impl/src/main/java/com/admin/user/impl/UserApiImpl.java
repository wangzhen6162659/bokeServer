package com.admin.user.impl;

import com.admin.user.api.UserApi;
import com.admin.user.configuration.GxqptWebappConfig;
import com.admin.user.dto.user.UserLoginDTO;
import com.admin.user.dto.user.UserLoginResDTO;
import com.admin.user.dto.user.UserResDTO;
import com.admin.user.dto.user.UserSaveDTO;
import com.admin.user.dto.user.UserUpdateDTO;
import com.admin.user.entity.po.User;
import com.admin.user.repository.base.example.UserExample;
import com.admin.user.repository.base.service.UserService;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.commons.sec.impl.BitEncryptUserToken;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
@Slf4j
@Api(value = "UserApi", description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserApiImpl implements UserApi {
    @Autowired
    UserService userService;
    @Autowired
    private GxqptWebappConfig gxqptWebappConfig;
    @Autowired
    DozerUtils dozerUtils;

    @Override
    @ApiOperation(value = "查找用户", notes = "根据id查找用户")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<UserResDTO> get(@RequestParam(value = "id") Long id) {
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(id);
        User user = userService.getUnique(example);
        UserResDTO res = dozerUtils.map(user, UserResDTO.class);
        if (res.getSelfLaber() != null) {
            res.setSelfLabers(Arrays.asList(user.getSelfLaber().split(",")));
        }
        return Result.success(res);
    }

    @Override
    @IgnoreToken
    @ApiOperation(value = "用户登录", notes = "根据用户登录实体进行登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<UserLoginResDTO> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (StringUtils.isEmpty(userLoginDTO.getAccount())){
            return Result.fail("请输入账号！");
        }
        if (StringUtils.isEmpty(userLoginDTO.getPassword())){
            return Result.fail("请输入密码！");
        }

        UserExample example = new UserExample();
        example.createCriteria().andAccountEqualTo(userLoginDTO.getAccount())
                .andPasswordEqualTo(userLoginDTO.getPassword());
        User user = userService.getUnique(example);

        String token = "";
        if (user != null) {
            token = setUserToken("/", user.getId().toString(), user.getAccount(), null);
            user.setNickname(URLEncoder.encode(user.getNickname(),"UTF-8"));
            user.setAutograph(URLEncoder.encode(user.getAutograph(),"UTF-8"));
        } else {
            return Result.fail("用户名或密码错误！");
        }
        UserLoginResDTO res = dozerUtils.map(user, UserLoginResDTO.class);
        res.setToken(token);
        return Result.success(res);
    }

    @Override
    @ApiOperation(value = "用户修改", notes = "根据用户修改实体进行修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<UserLoginResDTO> update(@RequestBody UserUpdateDTO dto) throws UnsupportedEncodingException {
        Long userId = BaseContextHandler.getAdminId();
        log.info(dto.getAutograph());
        log.info(dto.getAutograph());
        log.info(dto.getAutograph());
        log.info(dto.getAutograph());
        log.info(dto.getAutograph());
        User user = dozerUtils.map(dto, User.class);
        user.setId(userId);

        if (userService.updateByIdSelective(user) > 0) {
            user = userService.getById(userId);
            String token = setUserToken("/", user.getId().toString(), user.getAccount(), null);
            user.setNickname(URLEncoder.encode(user.getNickname(),"UTF-8"));
            UserLoginResDTO res = dozerUtils.map(user, UserLoginResDTO.class);
            res.setToken(token);
            return Result.success(res);
        }
        return Result.fail("fail");
    }

    @Override
    @IgnoreToken
    @ApiOperation(value = "用户新增", notes = "根据新增实体进行用户新增")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<UserResDTO> save(@RequestBody UserSaveDTO dto) throws UnsupportedEncodingException {
        UserExample example = new UserExample();
        example.createCriteria().andAccountEqualTo(dto.getAccount());
        if (userService.find(example).size()>0){
            return Result.fail("该用户已注册！");
        }

        User user = dozerUtils.map(dto,User.class);
        UserResDTO res = dozerUtils.map(userService.save(user),UserResDTO.class);
        res.setToken(setUserToken("/", user.getId().toString(), user.getAccount(), null));
        res.setNickname(URLEncoder.encode(res.getNickname(),"UTF-8"));
        return Result.success(res);
    }

    private String setUserToken(String appToken, String id, String name, String extJson) {
        BitEncryptUserToken userToken = new BitEncryptUserToken();
        return userToken.encoder(appToken, id, name, extJson);
    }

    private List<String> getUserToken(String token) {
        BitEncryptUserToken userToken = new BitEncryptUserToken();
        return userToken.uncoder(token);
    }
}
