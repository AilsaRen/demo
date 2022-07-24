package com.example.demo.exception;

/**
 * <p>Title: ResponseCode</p >
 * <p>Description: </p >
 * <p>Company: www.h-visions.com</p >
 * <p>create date: 2022/7/24</p >
 *
 * @author :xtren
 * @version :1.0.0
 */

public enum ResponseCode {
    /**
     * 100 199 用户业务的
     * 200 299 支付业务
     */
    SUCCESS(200, "请求成功"),
    NO_MESSAGE_AVAILABLE(404, "请是针对不存在的资源");
    ;

    private int code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}