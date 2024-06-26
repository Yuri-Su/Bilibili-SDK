package com.yuchang.bilibili.pojo.dto.login;

import com.yuchang.bilibili.pojo.dto.Response;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yurisu
 * @description 短信验证码DTO
 * @date 2024/6/24 21:19:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SmsDTO extends Response {

    /**
     * 短信登录 token
     */
    private CaptchaKeyDTO data;

}
