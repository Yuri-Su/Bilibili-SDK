package com.yuchang.bilibili.pojo.dto.login;

import com.yuchang.bilibili.pojo.dto.Response;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yurisu
 * @description 短信验证码登录返回结果
 * @date 2024/6/25 22:42:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SmsLoginDTO extends Response {

    /**
     * data对象
     */
    private SmsLoginDataDTO data;

    @Data
    public static class SmsLoginDataDTO {

        /**
         * 是否为新注册用户
         * <p>
         * false：非新注册用户
         * true：新注册用户
         */
        private Boolean is_new;

        /**
         * 未知，可能0就是成功吧
         */
        private Integer status;

        /**
         * 跳转 url
         * <p>
         * 默认为 <a href="https://www.bilibili.com">哔哩哔哩</a>
         */
        private String url;
    }
}
