package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 日志服务异常代码
 * 从65000~69999, 每个子模块加500， 每个异常代码+1
 */
public enum LogsExceptionCode implements BaseExceptionCode {
    ID_NULL(65000, "ID不允许为空"),

    FILE_NULL(65001, "上传日志文件不允许为空"),
    FILE_NAME_EMPTY(65002,"文件名称不允许为空"),
    LOG_TYPE_EMPTY(65003,"文件类型不允许为空"),
    LOG_DOCUMENT_EMPTY(65004,"文档ID不允许为空"),
    LOG_DATA_CHANNEL(65005,"采集渠道不允许为空"),
    ENTITY_NULL(65006, "实体对象未获取到值"),

    WARN_RESULT_NULL(65500,"处理意见不能为空"),
    WARN_IDS_NULL(65501,"处理记录IDS不能为空"),

    LOG_STARTTIME_EMPTY(66001,"开始时间不能为空"),
    LOG_ENDTIME_EMPTY(66002,"结束时间不能为空")

    ;
    private int code;
    private String msg;

    LogsExceptionCode(int code, String msg) {
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
