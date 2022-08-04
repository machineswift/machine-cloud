package com.machine.dragon.common.web.controller;

import lombok.Data;

import java.net.HttpURLConnection;

@Data
public class WebAPIResponse<T> {

    public WebAPIResponse(int status,
                          String code,
                          String message,
                          T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 状态码
     * {@link HttpURLConnection}
     */
    private int status;

    /**
     * code码(成功:SUCCESS)
     */
    private String code;

    /**
     * 当前时间戳
     */
    private Long timestamp;

    /**
     * 链路追踪Id
     */
    private String traceId;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public static <T> WebAPIResponse<T> data(T data) {
        return data("操作成功", data);
    }

    public static <T> WebAPIResponse<T> data(String msg, T data) {
        return data(HttpURLConnection.HTTP_OK, "SUCCESS", data, msg);
    }

    public static <T> WebAPIResponse<T> data(int status, String code, T data, String msg) {
        return new WebAPIResponse(status, code, msg, data);
    }

}
