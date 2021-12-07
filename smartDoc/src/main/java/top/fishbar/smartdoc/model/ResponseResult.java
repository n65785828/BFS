package top.fishbar.smartdoc.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResponseResult<T> extends CommonResult<T> implements Serializable {

    private static final long serialVersionUID = -7268040542410707954L;

    public ResponseResult() {
    }

    public ResponseResult(boolean success, String message) {
        this.setSuccess(success);
        this.setMessage(message);
    }


    public ResponseResult(boolean success) {
        this.setSuccess(success);
    }

    public ResponseResult(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public ResponseResult(boolean success, String message, T data) {
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(data);
    }

    public static ResponseResult ok() {
        return ok(BaseErrorCode.SUCCESS);
    }

    public static <T> ResponseResult<T> ok(BaseErrorCode msg) {
        return baseCreate(msg.getCode(), msg.getMessage(), true);
    }

    public static ResponseResult fail() {
        return fail(BaseErrorCode.FAIL);
    }

    public static ResponseResult fail(BaseErrorCode message) {
        return fail(message.getCode(), message.getMessage());
    }

    public static ResponseResult fail(String code, String msg) {
        return baseCreate(code, msg, false);
    }

    private static <T> ResponseResult<T> baseCreate(String code, String msg, boolean success) {
        ResponseResult result = new ResponseResult(){};
        result.setCode(code);
        result.setSuccess(success);
        result.setMessage(msg);
        result.setTimestamp(LocalDateTime.now().format( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
        return result;
    }

    public CommonResult<T> setResult(T data) {
        this.setData(data);
        return this;
    }

    public T getData() {
        return (T) super.getData();
    }

}
