package com.admin.user.impl;

import com.admin.user.api.ReplyApi;
import com.admin.user.dto.ReplyReqDTO;
import com.admin.user.dto.ReplyResDTO;
import com.admin.user.entity.domain.ReplyAndUserDO;
import com.admin.user.entity.po.Reply;
import com.admin.user.repository.base.service.ReplyService;
import com.admin.user.util.TreeUtil;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<ReplyResDTO> list = dozerUtils
                .mapList(replyService.findReply(id),ReplyResDTO.class);
        List newList = new ArrayList();
        for (ReplyResDTO dto:list){
            if(dto.getParentId()==-1){
                dto.setChildren(list.stream().filter(obj -> dto.getId()==obj.getParentId()).collect(Collectors.toList()));
                newList.add(dto);
            }
        }
//        list = TreeUtil.buildByRecursives(dozerUtils.mapList(list, ReplyResDTO.class));

        return newList;
    }

    @Override
    @RequestMapping(value = "/saveReply", method = RequestMethod.POST)
    public List<ReplyResDTO> saveReply(@RequestBody ReplyReqDTO replyReqDTO) {
        //1.设置实体
        Reply reply = dozerUtils.map(replyReqDTO,Reply.class);
        reply.setCreateUser(1l);
        reply.setUpdateUser(1l);
        reply.setUserId(1l);
        reply.setFabulous(0);

        //2.保存
        replyService.save(reply);
        List<ReplyResDTO> list = dozerUtils
                .mapList(replyService.findReply(reply.getArticleId()),ReplyResDTO.class);
        List newList = new ArrayList();
        for (ReplyResDTO dto:list){
            if(dto.getParentId()==-1){
                dto.setChildren(list.stream().filter(obj -> dto.getId()==obj.getParentId()).collect(Collectors.toList()));
                newList.add(dto);
            }
        }
        return newList;
    }
}
