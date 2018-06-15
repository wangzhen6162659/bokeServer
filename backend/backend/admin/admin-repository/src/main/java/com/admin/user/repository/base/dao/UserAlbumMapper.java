package com.admin.user.repository.base.dao;

import com.admin.user.entity.po.UserAlbum;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAlbumMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.admin.user.entity.po.UserAlbum, com.admin.user.repository.base.example.UserAlbumExample> {
    UserAlbum getByIndex(@Param(value = "id") Long id, @Param(value = "index") Long index);
}