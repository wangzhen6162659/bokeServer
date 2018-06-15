package com.admin.user.dto;

import com.admin.user.content.TreeNode;
import lombok.Data;

import java.util.Date;
@Data
public class ReplyResDTO extends TreeNode{

    private String content;

    private Long uId;

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
