package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

public enum WarnExceptionCode implements BaseExceptionCode{

    //预警信息管理相关 start
    WARN_ID_NULL(70500,"预警信息id为空"),
    //预警信息管理相关 end

    //预警类型管理相关 start
    WARN_TYPE_ID_NULL(71000,"预警类型信息id为空"),
    WARN_TYPE_DRAG_EXIST(71001,"拖动位置不正确"),
    WARN_TYPE_DRAG_ID_EXIST(71002,"获取当前拖动类型不正确"),
    //预警类型管理相关 end
    ;

    private int code;
    private String msg;

    WarnExceptionCode(int code, String msg) {
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
