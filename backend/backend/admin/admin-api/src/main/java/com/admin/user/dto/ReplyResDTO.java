package com.admin.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ReplyResDTO{

    private Long parentId;

    private Long userId;

    private String content;

    private Integer fabulous;

    private Long articleId;

    private String photo;

    private String nickname;

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
    @DateTimeFormat(pattern="MM-dd HH:mm")
    @JsonFormat(pattern="MM-dd HH:mm",timezone = "GMT+8")
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


    private Long replyId;
    private String replyName;
    private Long id;
    private Boolean activeTag = false;
    private Boolean replyWindow = false;
    private List children = new ArrayList<>();
}
