package com.yuchang.bilibili.pojo.dto.login;

import com.yuchang.bilibili.pojo.dto.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yurisu
 * @description 短信验证码登录返回结果
 * @date 2024/6/25 22:42:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(title = "短信验证码登录返回结果")
public class SmsLoginDTO extends Response {

    /**
     * data对象
     */
    private SmsLoginDataDTO data;

    @Data
    @Schema(title = "短信验证码登录返回信息")
    public static class SmsLoginDataDTO {

        @Schema(title = "是否为新注册用户", description = "false：非新注册用户 true：新注册用户")
        private Boolean is_new;

        @Schema(title = "未知", description = "可能0就是成功吧")
        private Integer status;

        @Schema(title = "跳转 url", description = "默认为 https://www.bilibili.com")
        private String url;
    }
}
