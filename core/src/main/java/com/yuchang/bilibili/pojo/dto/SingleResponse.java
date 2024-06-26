package com.yuchang.bilibili.pojo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SingleResponse<T> extends Response {

    private T data;

    public static <T> SingleResponse<T> of(T data) {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static <T> SingleResponse<T> of(Integer code, T data) {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(true);
        response.setCode(code);
        response.setData(data);
        return response;
    }

    public static <T> SingleResponse<T> of(Integer code, String message, T data) {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(true);
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

}