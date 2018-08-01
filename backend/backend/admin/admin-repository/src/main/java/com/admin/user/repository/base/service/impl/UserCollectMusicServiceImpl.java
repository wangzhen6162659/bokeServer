package com.admin.user.repository.base.service.impl;

import com.admin.user.entity.po.UserCollectMusic;
import com.admin.user.repository.base.dao.UserCollectMusicMapper;
import com.admin.user.repository.base.example.UserCollectMusicExample;
import com.admin.user.repository.base.service.UserCollectMusicService;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.base.service.normal.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCollectMusicServiceImpl extends BaseServiceImpl<Long,UserCollectMusic,UserCollectMusicExample> implements UserCollectMusicService {
    @Autowired
    private UserCollectMusicMapper musicMapper;

    @Override
    protected BaseNormalDao<Long, UserCollectMusic, UserCollectMusicExample> getDao() {
        return musicMapper;
    }
}