package com.admin.user.repository.base.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.admin.user.entity.po.Reply, com.admin.user.repository.base.example.ReplyExample> {
    List findReply(Long id);
}