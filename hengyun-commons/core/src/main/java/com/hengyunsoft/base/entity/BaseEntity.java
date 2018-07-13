package com.hengyunsoft.base.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tyh
 * @createTime 2017-12-08 17:34
 */
public abstract class BaseEntity<I extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract I getId();

    public abstract void setId(I id);


    public abstract Date getCreateTime();
    public abstract Date getUpdateTime();
    public abstract void setCreateTime(Date nowDate);
    public abstract void setUpdateTime(Date nowDate);
}
