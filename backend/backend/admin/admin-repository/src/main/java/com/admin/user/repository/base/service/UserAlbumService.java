package com.admin.user.repository.base.service;

import com.admin.user.entity.po.UserAlbum;
import com.admin.user.repository.base.example.UserAlbumExample;
import com.hengyunsoft.base.service.normal.BaseService;

public interface UserAlbumService extends BaseService<Long,UserAlbum,UserAlbumExample> {
    UserAlbum getByIndex(Long id, Long index);
}
