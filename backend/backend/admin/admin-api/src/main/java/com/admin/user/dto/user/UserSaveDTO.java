package com.admin.user.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "新增用户DTO")
public class UserSaveDTO {
    @ApiModelProperty(value = "新增用户")
    private String account;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户名称")
    private String nickname;
}
