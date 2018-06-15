package com.admin.user.api;

import com.admin.user.dto.ReplyResDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReplyApi {
    @RequestMapping(value = "/reply/findReply",method = RequestMethod.GET)
    List<ReplyResDTO> findReply(@RequestParam(value = "id")Long id);
}
