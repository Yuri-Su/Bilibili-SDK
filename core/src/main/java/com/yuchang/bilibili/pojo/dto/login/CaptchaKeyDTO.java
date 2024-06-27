package com.yuchang.bilibili.pojo.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author yurisu
 * @description 短信登录DTO
 * @date 2024/6/24 21:21:56
 */
@Data
@Schema(title = "短信登录")
public class CaptchaKeyDTO {

    @Schema(title = "短信登录 token")
    private String captcha_key;
}
