package com.admin.user.dto.articletype;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ArticleSaveReqDTO {
    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "文章类型")
    private String type;
}
