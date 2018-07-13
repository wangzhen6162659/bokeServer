package com.admin.user.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UserResDTO {
    private Long id;

    private String account;

    private String token;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    private String name;

    private String nickname;

    /**
     * 性别
     *
     * @mbggenerated
     */
    private String sex;

    /**
     * 生日
     *
     * @mbggenerated
     */
    private Date birthday;

    /**
     * 民族
     *
     * @mbggenerated
     */
    private String nation;

    /**
     * 照片
     *
     * @mbggenerated
     */
    private String photo;

    /**
     * 标签
     *
     * @mbggenerated
     */
    private String selfLaber;

    /**
     * 手机
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * 心情
     *
     * @mbggenerated
     */
    private String autograph;

    /**
     * 最后登录
     *
     * @mbggenerated
     */
    private Date lastLogin;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    @ApiModelProperty(value = "用户标签")
    private List<String> selfLabers = new ArrayList<>();
}
