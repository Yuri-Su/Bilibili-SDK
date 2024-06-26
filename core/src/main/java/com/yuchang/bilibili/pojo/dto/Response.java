package com.yuchang.bilibili.pojo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Response extends DTO {

    private boolean success;

    private Integer code;

    private String message;


    public static Response buildSuccess() {
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

    public static Response buildFailure(Integer errCode, String errMessage) {
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }
}