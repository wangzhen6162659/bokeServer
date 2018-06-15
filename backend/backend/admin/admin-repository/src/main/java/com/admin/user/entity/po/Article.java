package com.admin.user.entity.po;

import com.hengyunsoft.base.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Article extends BaseEntity<Long> implements Serializable {
    private Long id;

    private String title;

    private String content;

    private String type;

    private Long userId;

    private Integer fabulous;

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

    private static final long serialVersionUID = 1L;
}