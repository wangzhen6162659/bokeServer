package com.admin.user.repository.base.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.admin.user.entity.po.Article, com.admin.user.repository.base.example.ArticleExample> {
    List findTypeByUser(Long id);
}