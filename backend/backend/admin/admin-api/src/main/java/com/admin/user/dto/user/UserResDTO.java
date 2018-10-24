package com.admin.user.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "UserRes", description = "用户返回实体")
public class UserResDTO {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "账户")
    private String account;

    @ApiModelProperty(value = "token")
    private String token;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 性别
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 生日
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "生日")
    private Date birthday;

    /**
     * 民族
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "民族")
    private String nation;

    /**
     * 照片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "照片")
    private String photo;

    /**
     * 标签
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标签")
    private String selfLaber;

    /**
     * 手机
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机")
    private String phone;

    /**
     * 心情
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "心情")
    private String autograph;

    /**
     * 最后登录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "最后登录")
    private Date lastLogin;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人id")
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人id")
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "用户标签")
    private List<String> selfLabers = new ArrayList<>();
}
