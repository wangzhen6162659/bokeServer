package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 文件服务（gxqpt-file 项目）相关的异常代码
 *  60000~64999, 每个子模块加500， 每个异常代码+1
 */
public enum FileExceptionCode implements BaseExceptionCode {
    // 文件夹相关 start
    FOLDER_NULL(60000, "文件夹为空"),
    FOLDER_NAME_EMPTY(60001, "文件夹名称为空"),
    FOLDER_PARENT_NULL(60002, "父文件夹为空"),

    FILE_NULL(60100, "文件为空"),
    FILE_NAME_EMPTY(60101, "文件名称为空"),
    FILE_FOLDER_NULL(60102, "文件夹为空"),
    FILE_ID_NULL(60103, "文件id为空"),
    // 文件夹相关 end



    //分享文件相关 start
    SHARE_ISPWD_NULL(60500,"分享文件加密标识为空"),
    SHARE_VALID_NULL(60501,"分享文件保存期限标识为空"),
    SHARE_FILES_NULL(60502,"分享文件列表为空"),
    //分享文件相关 end

    // 截取图片 start
    IMAGE_WIDTH_TOO_SMALL( 61000, "图片宽度不能小于0"),
    IMAGE_HEIGHT_TOO_SMALL( 61001, "图片高度不能小于0"),
    //截取图片 end

    ;
    private int code;
    private String msg;

    FileExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
