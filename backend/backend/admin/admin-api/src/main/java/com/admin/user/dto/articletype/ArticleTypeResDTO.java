package com.admin.user.dto.articletype;

import lombok.Data;

@Data
public class ArticleTypeResDTO {
    private Long id;

    /**
     * 类型名称
     *
     * @mbggenerated
     */
    private String typeName;

    /**
     * 外键
     *
     * @mbggenerated
     */
    private Long userid;

    /**
     * 文章标签
     *
     * @mbggenerated
     */
    private String articlTag;

    /**
     * 描述
     *
     * @mbggenerated
     */
    private String typeDesc;
}
