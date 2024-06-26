package com.yuchang.bilibili.pojo.dto.login;

import lombok.Data;

/**
 * @author yurisu
 * @description 短信验证码DTO
 * @date 2024/6/24 21:19:05
 */
@Data
public class SmsDTO {

    /**
     * 返回值
     */
    private Integer code;

    /**
     * 错误信息 成功为0
     */
    private String message;

    /**
     * 短信登录 token
     */
    private CaptchaDTO data;

}
