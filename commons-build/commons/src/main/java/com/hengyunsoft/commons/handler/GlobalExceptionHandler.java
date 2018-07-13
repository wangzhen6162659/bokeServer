package com.hengyunsoft.commons.handler;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.ExceptionCode;
import com.hengyunsoft.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLException;
import java.util.List;

/**
 * @author tyh
 * @createTime 2017-12-13 17:04
 */
@ControllerAdvice(value = {
        "com.hengyunsoft.security",
        "com.hengyunsoft.platform.admin.impl",
        "com.hengyunsoft.platform.admin.open",
        "com.hengyunsoft.platform.developer.impl",
        "com.hengyunsoft.platform.developer.open",
        "com.hengyunsoft.platform.file.impl",
        "com.hengyunsoft.platform.file.open",
        "com.hengyunsoft.platform.mail.impl",
        "com.hengyunsoft.platform.mail.open",
        "com.hengyunsoft.platform.sms.impl",
        "com.hengyunsoft.platform.sms.open",
        "com.hengyunsoft.platform.logs.impl",
        "com.hengyunsoft.platform.logs.open",
        "com.hengyunsoft.platform.msgs.impl",
        "com.hengyunsoft.platform.msgs.open",
        "com.hengyunsoft.platform.search.impl",
        "com.hengyunsoft.platform.search.open",
        "com.hengyunsoft.platform.piping.impl",
        "com.hengyunsoft.platform.piping.open",
        "com.hengyunsoft.platform.warn.impl",
        "com.hengyunsoft.platform.warn.open",
        "com.hengyunsoft.platform.modular.impl",
        "com.hengyunsoft.platform.modular.open",
        "com.hengyunsoft.platform.standard.impl",
        "com.hengyunsoft.platform.standard.open",
        "com.hengyunsoft.platform.exchange.impl",
        "com.hengyunsoft.platform.exchange.open",
})
@ResponseBody  //返回结果为json
public class GlobalExceptionHandler {
    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BizException.class)
    public Result baseExceptionHandler(BizException ex) {
        log.error("BizException:", ex);
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result otherExceptionHandler(Exception ex) {
        log.error("Exception:", ex);
        //if(ex instanceof DataIntegrityViolationException){
        //}
        try {
            if (ex instanceof HttpMessageNotReadableException) {  //入参为 @RequestBody 时，json参数类型错误，json参数格式不对
                String message = ex.getMessage();
                if (message != null && !"".equals(message)) {
                    if (message.contains("Could not read document:")) {
                        String msg = "无法正确的解析json类型的参数：" +
                                message.substring(message.indexOf("Could not read document:") +
                                        "Could not read document:".length(), message.indexOf(" at "));
                        return new Result(ExceptionCode.PARAM_EX.getCode(), null, msg);
                    }
                }
                return new Result(ExceptionCode.PARAM_EX.getCode(), null, ExceptionCode.PARAM_EX.getMsg());
            } else if (ex instanceof BindException){  //入参
                BindException eee = ((BindException) ex);
                StringBuilder msg = new StringBuilder();
                List<FieldError> fieldErrors = eee.getFieldErrors();
                fieldErrors.forEach((oe)->{
                    msg.append("参数对象[").append(oe.getObjectName()).append("]的字段[")
                            .append(oe.getField()).append("]的值[").append(oe.getRejectedValue()).append("]与实际类型不匹配.");

                });

                return new Result(ExceptionCode.PARAM_EX.getCode(), null, msg.toString());
            }
            else if (ex instanceof MethodArgumentTypeMismatchException) {
                MethodArgumentTypeMismatchException eee = ((MethodArgumentTypeMismatchException) ex);
                StringBuilder msg = new StringBuilder("参数[").append(eee.getName()).append("]的值[")
                        .append(eee.getValue()).append("]与实际类型[").append(eee.getRequiredType().getName()).append("]不匹配");
                return new Result(ExceptionCode.PARAM_EX.getCode(), null, msg.toString());
            } else if(ex instanceof IllegalStateException){ // 非法参数
                return new Result(ExceptionCode.ILLEGALA_RGUMENT_EX.getCode(), null, ExceptionCode.ILLEGALA_RGUMENT_EX.getMsg());

            } else if(ex instanceof MissingServletRequestParameterException){ // 缺少参数
                MissingServletRequestParameterException e = ((MissingServletRequestParameterException) ex);
                StringBuilder msg = new StringBuilder();
                msg.append("缺少必须的[").append(e.getParameterType()).append("] 类型的参数[").append(e.getParameterName()).append("]");
                return new Result(ExceptionCode.ILLEGALA_RGUMENT_EX.getCode(), null, msg.toString());
            }
            else if (ex instanceof NullPointerException) {
                return new Result(ExceptionCode.NULL_POINT_EX.getCode(), null, ExceptionCode.NULL_POINT_EX.getMsg());
            } else if (ex instanceof IllegalArgumentException) {
                return new Result(ExceptionCode.ILLEGALA_RGUMENT_EX.getCode(), null, ExceptionCode.ILLEGALA_RGUMENT_EX.getMsg());
            } else if (ex instanceof SQLException) {
                return new Result(ExceptionCode.SQL_EX.getCode(), null, ExceptionCode.SQL_EX.getMsg());
            } else if (ex instanceof DataIntegrityViolationException){
                return new Result(ExceptionCode.SQL_EX.getCode(), null, ExceptionCode.SQL_EX.getMsg());
            } else if(ex instanceof HttpMediaTypeNotSupportedException){
                HttpMediaTypeNotSupportedException e = ((HttpMediaTypeNotSupportedException) ex);
                MediaType contentType = e.getContentType();
                if(contentType != null) {
                    StringBuilder msg = new StringBuilder();
                    msg.append("请求类型(Content-Type)[").append(contentType.toString()).append("] 与实际接口的请求类型不匹配");
                    return new Result(ExceptionCode.MEDIA_TYPE_EX.getCode(), null, msg.toString());
                }
                return new Result(ExceptionCode.MEDIA_TYPE_EX.getCode(), null, "无效的Content-Type类型");
            }
        } catch (Exception e) {
            log.error("解析 Exception", e);
        }
        return new Result(ExceptionCode.SYSTEM_BUSY.getCode(), null, ex.getMessage());
    }


}