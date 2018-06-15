package com.admin.user.dto;

import lombok.Data;

import java.util.Date;
@Data
public class BaseReplyDTO {
    private Long id;

    private String content;

    private Long pId;

    private Long uId;

    private Integer fabulous;

    private Long articleId;

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
}
