package com.liuyun.utils.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName liuyun-security
 * @ClassName Result
 * @Description
 * @Author WangDong
 * @Date 2019/10/29 14:23
 * @Version 2.1.3
 **/
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 4072468340586088980L;

    /**
     * 正常状态编码
     */
    public static final Integer SUCCESS_CODE = 200;

    /**
     * 正常状态编码
     */
    public static final Integer FAIL_CODE = 500;

    /**
     * 正常状态信息
     */
    public static final String SUCCESS_MSG = "操作成功！";

    /**
     * 异常状态信息
     */
    public static final String FAIL_MSG = "系统异常，请联系管理员！";

    /**
     * 异常状态信息
     */
    public static final String FAIL_HYSTRIX_MSG = "系统繁忙请稍后再试！！！";

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 返回处理消息
     */
    private String message;

    /**
     * 时间戳
     */
    private long timestamp;

    /**
     * 返回数据对象
     */
    private T result;

    public Result() {
        this.code = SUCCESS_CODE;
        this.message = SUCCESS_MSG;
        this.timestamp = System.currentTimeMillis();
        this.result = null;
    }

    public static Result success() {
        return new Result();
    }

    public static Result<Object> success(Object data) {
        Result<Object> r = new Result<>();
        r.setResult(data);
        return r;
    }

    public static <T> Result <T> successT(T t) {
        Result<T> r = new Result<>();
        r.setResult(t);
        return r;
    }

    public static Result<Object> success(String message, Object data) {
        Result<Object> r = new Result<>();
        r.setMessage(message);
        r.setResult(data);
        return r;
    }

    public static Result<Object> fail(String message) {
        return fail(FAIL_CODE, message);
    }

    public static Result<Object> fail(Integer code, String msg) {
        Result<Object> r = new Result<Object>();
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }
}
