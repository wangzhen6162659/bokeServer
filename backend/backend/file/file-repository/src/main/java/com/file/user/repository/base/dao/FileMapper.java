package com.file.user.repository.base.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface FileMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.file.user.entity.po.File, com.file.user.repository.base.example.FileExample> {
}