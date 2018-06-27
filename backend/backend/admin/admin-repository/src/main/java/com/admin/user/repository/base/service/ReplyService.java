package com.admin.user.repository.base.service;

import com.admin.user.entity.po.Reply;
import com.admin.user.repository.base.example.ReplyExample;
import com.hengyunsoft.base.service.normal.BaseService;

import java.util.List;

public interface ReplyService extends BaseService<Long,Reply,ReplyExample>{
    List findReply(Long id);

    Object getReply(Long id);
}
