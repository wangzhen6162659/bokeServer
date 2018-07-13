package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;
/**
 * 消息服务异常代码
 * 从70000~74999, 每个子模块加500， 每个异常代码+1
 */
public enum MsgExceptionCode implements BaseExceptionCode {

//    一、渠道组名称 长度32 ，必填；描述最长100 description ，不必填；其它渠道名字不为空
//    二、消息：1、标题 title 当是微博类型时，title必填，最长100，其它类型时不必填；
//            2、消息文本内容msg_txt 必填，最长1000；其它渠道名字不为空  ；
//            3、常用联系人contact_person 当是短信类型，必填，其它类型可空 250

    ID_NULL(70000, "ID不允许为空"),
    // 渠道start
    CHANNELTYPE_EMPTY(70501, "渠道分类为空"),
    CHANNEL_NAME_EMPTY(70502, "渠道名称为空"),
    CHANNEL_NAME_LENG(70503, "渠道名称长度最长"),
    CHANNEL_APPID_EMPTY(70504, "应用系统ID为空"),
    CHANNEL_APPID_LENG(70505, "应用系统ID长度最长"),
    CHANNEL_APPPSECRET_EMPTY(70506, "密钥为空"),
    CHANNEL_APPPSECRET_LENG(70507, "密钥长度最长"),
    // 渠道end

    // 渠道组start
    CHANNELGROUP_NAME_EMPTY(71002, "渠道群组名称为空"),
    CHANNELGROUP_NAME_LENG(71003, "渠道群组名称长度最长32"),
    CHANNELGROUP_NAME_DECRIPTION(71004, "渠道群组描述长度最长100"),
    // 渠道组end

    // 消息start
    MESSAGE_CONTACTPERSON_EMPTY(71501, "联系人为空"),
    MESSAGE_CONTACTPERSON_LENG(71502, "联系人长度最长250"),
    MESSAGE_TITLE_EMPTY(71503, "标题为空"),
    MESSAGE_TITLE_LENG(71504, "标题长度最长32"),
    MESSAGE_MSGTXT_EMPTY(71505, "消息文本内容为空"),
    MESSAGE_MSGTXT_LENG(71506, "消息文本内容长度最长1000"),
    // 消息end
    ;
    private int code;
    private String msg;

    MsgExceptionCode(int code, String msg) {
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
