package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 共享交换-数据目录服务异常代码
 * 从85000~90000, 每个子模块加500， 每个异常代码+1
 */
public enum DirectoryExceptionCode implements BaseExceptionCode {

    DIRECTORY_ID_NULL(85000, "数据目录ID不允许为空"),
    DIRECTORY_NAME_NULL(85001, "数据目录名称不允许为空"),
    DIRECTORY_ABBR_NULL(85002, "数据目录简称不允许为空"),
    DIRECTORY_TYPE_NULL(85003, "数据目录标识名称不允许为空"),
    DIRECTORY_PARENTID_NULL(85003, "数据目录父id不允许为空"),
    ;
    private int code;
    private String msg;

    DirectoryExceptionCode(int code, String msg) {
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
