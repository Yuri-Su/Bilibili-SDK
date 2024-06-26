package com.yuchang.bilibili.pojo.dto.captcha;

import lombok.Data;

/**
 * @author yurisu
 * @description 人机验证响应
 * @date 2024/6/20 22:39:52
 */
@Data
public class CaptchaDTO {

    private Integer code;

    private String message;

    private Integer ttl;

    private CaptchaDataDTO data;

    @Data
    private static class CaptchaDataDTO {

        /**
         * 极验captcha数据
         */
        private GeetestDTO geetest;

        /**
         * (?)	作用尚不明确
         */
        private Object tencent;

        /**
         * 登录 API token
         * <p> 与 captcha 无关，与登录接口有关
         */
        private String token;

        /**
         * 验证方式
         * <p> 用于判断使用哪一种验证方式，目前所见只有极验
         * geetest：极验
         */
        private String type;
    }

}
