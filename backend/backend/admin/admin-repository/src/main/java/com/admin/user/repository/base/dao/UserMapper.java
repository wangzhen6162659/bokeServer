package com.admin.user.repository.base.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.admin.user.entity.po.User, com.admin.user.repository.base.example.UserExample> {
}