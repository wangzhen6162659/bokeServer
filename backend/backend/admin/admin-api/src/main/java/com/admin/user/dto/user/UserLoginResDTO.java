package com.admin.user.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "UserLoginRes")
public class UserLoginResDTO {
    @ApiModelProperty(value = "用户token")
    private String token;
    @ApiModelProperty(value = "用户id")
    private String id;
    @ApiModelProperty(value = "用户昵称")
    private String nickname;
    @ApiModelProperty(value = "用户头像")
    private String photo;
    @ApiModelProperty(value = "用户心情")
    private String autograph;
}
