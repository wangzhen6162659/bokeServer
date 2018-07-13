package com.admin.user.impl;

import com.admin.user.api.ReplyApi;
import com.admin.user.dto.ReplyReqDTO;
import com.admin.user.dto.ReplyResDTO;
import com.admin.user.entity.po.Reply;
import com.admin.user.repository.base.service.ReplyService;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ReplyApiImpl implements ReplyApi {
    @Autowired
    ReplyService replyService;
    @Autowired
    DozerUtils dozerUtils;

    @Override
    @IgnoreToken
    @RequestMapping(value = "/findReply", method = RequestMethod.GET)
    public Result<List<ReplyResDTO>> findReply(@RequestParam(value = "id") Long id) {
        List<ReplyResDTO> list = dozerUtils
                .mapList(replyService.findReply(id), ReplyResDTO.class);
        List newList = new ArrayList();
        for (ReplyResDTO dto : list) {
            if (dto.getParentId() == -1) {
                dto.setChildren(list.stream().filter(
                        obj -> dto.getId().longValue() == obj.getParentId().longValue()).collect(Collectors.toList()));
                newList.add(dto);
            }
        }
//        list = TreeUtil.buildByRecursives(dozerUtils.mapList(list, ReplyResDTO.class));

        return Result.success(newList);
    }

    @Override
    @RequestMapping(value = "/saveReply", method = RequestMethod.POST)
    public Result<ReplyResDTO> saveReply(@RequestBody ReplyReqDTO replyReqDTO) {
        log.info(Thread.currentThread().getName());
        //1.设置实体
        Long userId = BaseContextHandler.getAdminId();
        Reply reply = dozerUtils.map(replyReqDTO, Reply.class);
        reply.setCreateUser(userId);
        reply.setUpdateUser(userId);
        reply.setUserId(userId);
        reply.setFabulous(0);

        //2.保存
        reply = replyService.save(reply);
        List<ReplyResDTO> list = dozerUtils
                .mapList(replyService.findReply(reply.getArticleId()), ReplyResDTO.class);
        for (ReplyResDTO dto : list) {
            if (reply.getParentId().equals(-1l)) {
                if (dto.getId().equals(reply.getId())) {
                    return Result.success(dto);
                }
            } else if (dto.getParentId().longValue() == -1 && dto.getId().equals(reply.getParentId())) {
                dto.setChildren(list.stream().filter(obj -> dto.getId().longValue() == obj.getParentId().longValue()).collect(Collectors.toList()));
                return Result.success(dto);
            }
        }
        return Result.fail("未找到根节点");
    }
}
