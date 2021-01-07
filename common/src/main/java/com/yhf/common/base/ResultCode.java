package com.yhf.common.base;

public enum ResultCode {

    SUCCESS(200, "SUCCESS"),//访问成功

    SERVER_ERROR(500, "SERVER_ERROR"),//服务器错误

    SERVER_MSG(101, "ERROR_MSG"),//错误/验证 提示信息
    OPERATION_FAILURE(101, "操作失败"),//操作失败提示信息

    TOKEN_NULL(2001, "请登陆"),//未登陆
    TOKEN_LOSE(2001, "用户信息失效 请重新登陆"),//登陆信息失效
    TOKEN_ERRO(2001, "用户信息错误 请重新登陆");//登陆信息错误


    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }


}
