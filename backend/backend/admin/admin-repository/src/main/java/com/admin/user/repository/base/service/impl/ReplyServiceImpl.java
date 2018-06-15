package com.admin.user.repository.base.service.impl;

import com.admin.user.entity.po.Reply;
import com.admin.user.repository.base.dao.ReplyMapper;
import com.admin.user.repository.base.example.ReplyExample;
import com.admin.user.repository.base.service.ReplyService;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl extends BaseServiceImpl<Long,Reply,ReplyExample> implements ReplyService{
    @Autowired
    ReplyMapper mapper;

    @Override
    protected BaseNormalDao<Long, Reply, ReplyExample> getDao() {
        return this.mapper;
    }

    @Override
    public List findReply(Long id) {
        return mapper.findReply(id);
    }
}
