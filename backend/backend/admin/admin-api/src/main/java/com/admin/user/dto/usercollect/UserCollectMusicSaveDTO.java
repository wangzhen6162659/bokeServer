package com.admin.user.dto.usercollect;

import lombok.Data;

@Data
public class UserCollectMusicSaveDTO {
    private Long id;

    private Long albumId;

    private String albumName;

    private Integer musicDur;

    private Long musicId;

    private String musicName;

    private String musicPicurl;

    private Long singerId;

    private String singerName;

    private Long userId;
}
