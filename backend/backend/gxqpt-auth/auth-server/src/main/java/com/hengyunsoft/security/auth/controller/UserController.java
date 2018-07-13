//package com.hengyunsoft.security.auth.controller;
//
//import com.admin.user.entity.po.User;
//import com.admin.user.repository.base.example.UserExample;
//import com.admin.user.repository.base.service.UserService;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
//import com.hengyunsoft.commons.utils.context.DozerUtils;
//import com.hengyunsoft.sec.ISecurityStrategy;
//import com.hengyunsoft.sec.PasswordEncoder;
//import com.hengyunsoft.security.auth.dto.UserDTO;
//import com.hengyunsoft.utils.BizAssert;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import springfox.documentation.annotations.ApiIgnore;
//
//@RestController
//@Slf4j
//@Api(value = "API - UserController", description = "用户登录账号密码验证管理")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private DozerUtils dozerUtils;
//
//    @Value("${gxqpt.randomstr}")
//    private String randomstr;
//    @Autowired
//    private ISecurityStrategy securityStrategy;
//    private final long HOURSE = 1 * 60 * 60 * 1000;
//
//
//    //    @ApiIgnore
//    @ApiOperation(value = "登录验证", notes = "Response Messages 中的HTTP Status Code 值的是errcode的值")
//    @RequestMapping(value = "/p/login", method = RequestMethod.POST)
//    public Result<UserDTO> login(String account, String password) {
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, account);
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, password);
//        String enCoderPassword = PasswordEncoder.encoder(password);
//
//        User user = userService.getLogin(account, enCoderPassword);
//        BizAssert.assertNotNull(AuthorityExceptionCode.USER_NAME_PWD_ERROR, user);
//        return Result.success(dozerUtils.map(user, UserDTO.class));
//    }
////    public Result<UserDTO> login(String account, String password, String secCode) {
////        if (!pass(secCode)) {
////            return Result.fail("无权限访问");
////        }
////        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, account);
////        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, password);
////        User user = userService.getLogin(account, password);
////        BizAssert.assertNotNull(AuthorityExceptionCode.USER_NAME_PWD_ERROR, user);
////        return Result.success(dozerUtils.map(user, UserDTO.class));
////    }
//
////    private Boolean pass(String secCode) {
////        try {
////            String dateTime = securityStrategy.uncrypt(randomstr, secCode);
////            long distance = System.currentTimeMillis() - Long.valueOf(dateTime);
////
////            return Math.abs(distance) < HOURSE;
////        } catch (Exception e) {
////            return false;
////        }
////    }
//
//    @ApiIgnore
//    @RequestMapping(value = "/user/getById", method = RequestMethod.GET)
//    public Result<UserDTO> getById(@RequestParam(value = "id") Long id) {
//        User user = userService.getById(id);
//        System.out.println("id=" + id + "user=" + user);
//        UserDTO dto = dozerUtils.map(user, UserDTO.class);
//        return Result.success(dto);
//    }
//
//    @ApiIgnore
//    @RequestMapping(value = "/user/getByAccount", method = RequestMethod.GET)
//    public Result<UserDTO> getByAccount(@RequestParam(value = "account") String account) {
//        UserExample example = new UserExample();
//        example.createCriteria().andAccountEqualTo(account);
//        User user = userService.getUnique(example);
//        UserDTO dto = dozerUtils.map(user, UserDTO.class);
//        return Result.success(dto);
//    }
//
//
//}
