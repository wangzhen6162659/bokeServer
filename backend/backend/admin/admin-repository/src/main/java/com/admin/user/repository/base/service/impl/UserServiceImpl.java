package com.admin.user.repository.base.service.impl;

import com.admin.user.entity.po.User;
import com.admin.user.repository.base.dao.UserMapper;
import com.admin.user.repository.base.example.UserExample;
import com.admin.user.repository.base.service.UserService;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<Long,User,UserExample> implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    protected BaseNormalDao<Long, User, UserExample> getDao() {
        return this.mapper;
    }
}
