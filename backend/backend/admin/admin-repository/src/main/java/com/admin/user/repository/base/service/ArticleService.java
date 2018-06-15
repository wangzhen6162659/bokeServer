package com.admin.user.repository.base.service;

import com.admin.user.entity.po.Article;
import com.admin.user.repository.base.example.ArticleExample;
import com.hengyunsoft.base.service.normal.BaseService;

import java.util.List;

public interface ArticleService extends BaseService<Long,Article,ArticleExample> {
    List findTypeByUser(Long id);
}
