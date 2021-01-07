package com.yhf.common.base;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -6195242965433792011L;
    private Integer code;
    private String message;
    private T data;

    public Result() {

    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }


    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result booleans(Boolean res) {
        Result result = new Result();
        Map<String, Object> map = new HashMap();
        if (res) {
            result.setResultCode(ResultCode.SUCCESS);

        } else {
            result.setResultCode(ResultCode.OPERATION_FAILURE);
        }
        result.setData(res);
        return result;
    }

    public static Result msg(String msg) {
        Result result = new Result();
        result.setCode(101);
        result.setMessage(msg);
        result.setData(msg);
        return result;
    }

    public static Result loginError(String msg) {
        Result result = new Result();
        result.setMessage(msg);
        result.setCode(2001);
        result.setData(msg);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

}
