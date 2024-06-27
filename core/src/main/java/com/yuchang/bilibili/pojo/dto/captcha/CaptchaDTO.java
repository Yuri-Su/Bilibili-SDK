package com.yuchang.bilibili.pojo.dto.captcha;

import com.yuchang.bilibili.pojo.dto.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yurisu
 * @description 人机验证响应
 * @date 2024/6/20 22:39:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(title = "人机验证")
public class CaptchaDTO extends Response {

    private Integer ttl;

    @Schema(title = "信息")
    private CaptchaDataDTO data;

    @Data
    @Schema(title = "人机验证信息")
    public static class CaptchaDataDTO {

        @Schema(title = "极验captcha数据")
        private GeetestDTO geetest;

        /**
         * (?)	作用尚不明确
         */
        @Schema(description = "作用尚不明确")
        private Object tencent;

        @Schema(title = "登录 API token", description = "与 captcha 无关，与登录接口有关")
        private String token;

        @Schema(title = "验证方式", description = "用于判断使用哪一种验证方式，目前所见只有极验 geetest：极验")
        private String type;
    }

}
