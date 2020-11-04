package com.xiaotao.response;

public enum ResultCodeImpl implements ResultCode{
    SUCCESS(0, "成功"),

    ERROR(99, "失败"),

    ARITHMETIC_EXCEPTION(3001, "算数异常"),

    USER_NOT_FOUND(3002, "用户不存在"),

    DEPT_NOT_FOUND(3003, "未查询到部门信息"),

    PASS_NOT_CORRECT(3005, "密码不正确,请重新尝试"),

    NOT_LOGIN(3006, "尚未登录!"),

    INTRODUCTION_NOT_FOUND(2005,"没有找到这一条历史信息!"),

    PAGE_NOT_FOUND(404, "你的请求页面好像飘走了..."),

    INTERNAL_SERVER_ERROR(500,"服务器异常"),

    UNKNOW_SERVER_ERROR(2001,"未知异常,请联系管理员!");

    private Integer code;

    private String message;

    ResultCodeImpl(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}