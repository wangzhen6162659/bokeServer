package com.admin.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ReplyReqDTO {

    private Long parentId;

    private Long userId;

    private String content;

    private Long articleId;

    private Long replyId;
}
