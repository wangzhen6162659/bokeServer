package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 全局错误码 10000-15000
 *
 * @author tyh
 * @createTime 2017-12-13 16:22
 */
public enum ExceptionCode implements BaseExceptionCode {

    //系统相关 start
    SYSTEM_BUSY(-1, "系统繁忙，请稍候再试"),
    SYSTEM_TIMEOUT(-2, "系统超时，请稍候再试"),
    PARAM_EX(-3, "参数类型解析异常"),
    SQL_EX(-4, "数据库异常"),
    NULL_POINT_EX(-5, "空指针异常"),
    ILLEGALA_RGUMENT_EX(-6, "无效参数异常"),
    MEDIA_TYPE_EX(-7, "请求类型异常"),
    //系统相关 end

    //DB相关 10000 start
    DB_REMOVE_ERROR(10000, "无法软删除"),
    //DB相关 end

    //jwt token 相关 start
    //过期
    JWT_TOKEN_EXPIRED(40001, "token超时，请检查 token 的有效期"),
    //签名错误
    JWT_SIGNATURE(40002, "不合法的token，请认真比对 token 的签名"),
    //token 为空
    JWT_ILLEGAL_ARGUMENT(40003, "缺少token参数"),
    JWT_GEN_TOKEN_FAIL(40004, "生成token失败"),
    JWT_PARSER_TOKEN_FAIL(40005, "解析token失败"),
    JWT_APPID_SECRET_INVALID(40006, "获取 access_token 时 AppSecret 错误，或者 AppId 无效！"),
    JWT_APPID_ENABLED(40007, "AppId 已经被禁用！请联系管理员"),
    //jwt token 相关 end

    //文章相关//
    ARTICLE_TYPE_NAME_NULL(50001, "文章类型不能为空"),
    ARTICLE_NAME_NULL(50002, "文章名不能为空"),
    ARTICLE_CONTENT_NULL(50003, "文章内容不能为空"),
    ARTICLE_TITLE_NULL(50003, "文章标题不能为空"),
    ;



    private int code;
    private String msg;

    ExceptionCode(int code, String msg) {
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
