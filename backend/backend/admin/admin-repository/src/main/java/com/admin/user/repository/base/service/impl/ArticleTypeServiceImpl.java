package com.admin.user.repository.base.service.impl;

import com.admin.user.entity.po.ArticleType;
import com.admin.user.repository.base.dao.ArticleTypeMapper;
import com.admin.user.repository.base.example.ArticleTypeExample;
import com.admin.user.repository.base.service.ArticleService;
import com.admin.user.repository.base.service.ArticleTypeService;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleTypeServiceImpl extends BaseServiceImpl<Long,ArticleType,ArticleTypeExample> implements ArticleTypeService{
    @Autowired
    private ArticleTypeMapper mapper;

    @Override
    protected BaseNormalDao<Long, ArticleType, ArticleTypeExample> getDao() {
        return this.mapper;
    }
}
