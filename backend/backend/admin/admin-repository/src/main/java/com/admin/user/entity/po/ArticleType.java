package com.admin.user.entity.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ArticleType extends BaseEntity<Long> implements Serializable {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 类型名称
     *
     * @mbggenerated
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 类型名称
     *
     * @mbggenerated
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 外键
     *
     * @mbggenerated
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 外键
     *
     * @mbggenerated
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 文章标签
     *
     * @mbggenerated
     */
    public String getArticlTag() {
        return articlTag;
    }

    /**
     * 文章标签
     *
     * @mbggenerated
     */
    public void setArticlTag(String articlTag) {
        this.articlTag = articlTag == null ? null : articlTag.trim();
    }

    /**
     * 描述
     *
     * @mbggenerated
     */
    public String getTypeDesc() {
        return typeDesc;
    }

    /**
     * 描述
     *
     * @mbggenerated
     */
    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc == null ? null : typeDesc.trim();
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}