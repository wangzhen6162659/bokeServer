package com.admin.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseUserAlbumDTO {
    private Long id;

    private String albumName;

    private String path;

    private String url;

    private Long userId;

    private String desc;

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
