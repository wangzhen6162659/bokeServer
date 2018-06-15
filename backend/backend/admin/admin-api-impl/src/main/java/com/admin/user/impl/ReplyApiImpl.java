package com.admin.user.impl;

import com.admin.user.api.ReplyApi;
import com.admin.user.dto.ReplyResDTO;
import com.admin.user.entity.domain.ReplyAndUserDO;
import com.admin.user.repository.base.service.ReplyService;
import com.admin.user.util.TreeUtil;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reply")
public class ReplyApiImpl implements ReplyApi{
    @Autowired
    ReplyService replyService;
    @Autowired
    DozerUtils dozerUtils;

    @Override
    @RequestMapping(value = "/findReply", method = RequestMethod.GET)
    public List<ReplyResDTO> findReply(@RequestParam(value = "id")Long id) {
        List list = replyService.findReply(id);

        list = TreeUtil.buildByRecursives(dozerUtils.mapList(list, ReplyResDTO.class));

        return list;
    }
}
