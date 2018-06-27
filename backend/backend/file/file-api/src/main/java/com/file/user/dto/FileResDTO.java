package com.file.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FileResDTO {
    private Long id;

    private String fileName;

    private String realName;

    private Long userId;

    private String path;

    private String url;

    private String size;

    private String mime;

    private String ext;

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
