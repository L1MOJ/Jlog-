package com.limoj.jlog.enums;

public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    CATEGORYNAME_EXIST(233,"该分类已存在"),
    ARTICLE_EXIST(234,"标题已存在，请换个文章标题"),
    SYSTEM_ERROR(500,"出现错误"),
    NO_INPUT(400,"内容不能为空"),
    LOGIN_ERROR(505,"用户名或密码错误");
    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
