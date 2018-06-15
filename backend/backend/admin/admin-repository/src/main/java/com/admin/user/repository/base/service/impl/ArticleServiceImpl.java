package com.admin.user.repository.base.service.impl;

import com.admin.user.entity.po.Article;
import com.admin.user.repository.base.dao.ArticleMapper;
import com.admin.user.repository.base.example.ArticleExample;
import com.admin.user.repository.base.service.ArticleService;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Long, Article, ArticleExample>implements ArticleService{
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    protected BaseNormalDao<Long, Article, ArticleExample> getDao() {
        return this.articleMapper;
    }

    @Override
    public List findTypeByUser(Long id) {
        return articleMapper.findTypeByUser(id);
    }
}
