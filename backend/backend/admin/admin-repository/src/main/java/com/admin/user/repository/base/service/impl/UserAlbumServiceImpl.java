package com.admin.user.repository.base.service.impl;

import com.admin.user.entity.po.UserAlbum;
import com.admin.user.repository.base.dao.UserAlbumMapper;
import com.admin.user.repository.base.example.UserAlbumExample;
import com.admin.user.repository.base.service.UserAlbumService;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAlbumServiceImpl extends BaseServiceImpl<Long,UserAlbum,UserAlbumExample> implements UserAlbumService {
    @Autowired
    private UserAlbumMapper mapper;

    @Override
    protected BaseNormalDao<Long, UserAlbum,UserAlbumExample> getDao() {
        return this.mapper;
    }

    @Override
    public UserAlbum getByIndex(Long id, Long index) {
        return mapper.getByIndex(id,index);
    }
}

