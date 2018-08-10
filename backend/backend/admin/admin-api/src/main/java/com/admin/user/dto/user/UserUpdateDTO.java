package com.admin.user.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
@ApiModel(description = "用户修改dto")
public class UserUpdateDTO {
    @ApiModelProperty(value = "用户姓名")
    private String name;
    @ApiModelProperty(value = "用户头像")
    private String photo;
    @ApiModelProperty(value = "用户标签")
    private List<String> selfLabers;
    @ApiModelProperty(value = "用户心情")
    private String autograph;
    @ApiModelProperty(value = "用户性别")
    private String sex;
}
