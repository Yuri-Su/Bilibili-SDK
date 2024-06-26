package com.yuchang.bilibili.pojo.dto.login;

import lombok.Data;

/**
 * @author yurisu
 * @description 短信登录DTO
 * @date 2024/6/24 21:21:56
 */
@Data
public class CaptchaKeyDTO {

    /**
     * 短信登录 token
     */
    private String captcha_key;
}
