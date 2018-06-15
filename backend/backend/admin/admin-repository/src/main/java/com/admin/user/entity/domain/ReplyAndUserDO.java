package com.admin.user.entity.domain;

import com.admin.user.entity.po.Reply;
import lombok.Data;

@Data
public class ReplyAndUserDO extends Reply{
    private String photo;
    private String nickname;
}
