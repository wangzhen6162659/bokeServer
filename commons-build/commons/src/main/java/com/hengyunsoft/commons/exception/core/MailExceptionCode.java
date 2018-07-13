package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;
/**
 * 消息服务异常代码
 * 从40000~44999, 每个子模块加500， 每个异常代码+1
 */
public enum MailExceptionCode implements BaseExceptionCode {

    ;
    private int code;
    private String msg;

    MailExceptionCode(int code, String msg) {
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