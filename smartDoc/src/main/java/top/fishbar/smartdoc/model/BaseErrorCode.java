package top.fishbar.smartdoc.model;

public enum BaseErrorCode {

    SUCCESS("ok","调用成功"),
    FAIL("fail","调用失败");

    private String code;
    private String message;

    BaseErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
