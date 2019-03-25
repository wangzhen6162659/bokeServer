package com.admin.user.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@ApiModel(description = "新增用户DTO")
public class UserSaveDTO {
    @Length(max = 16)
    @ApiModelProperty(value = "新增用户")
    private String account;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户名称")
    private String nickname;
    @ApiModelProperty(value = "默认头像")
    private String photo;
}
