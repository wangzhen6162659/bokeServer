package com.file.user.repository.base.service.impl;

import com.file.user.entity.po.File;
import com.file.user.repository.base.dao.FileMapper;
import com.file.user.repository.base.example.FileExample;
import com.file.user.repository.base.service.FileService;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl extends BaseServiceImpl<Long,File,FileExample> implements FileService{
    @Autowired
    private FileMapper mapper;

    @Override
    protected BaseNormalDao<Long, File, FileExample> getDao() {
        return this.mapper;
    }
}
