package com.yuchang.bilibili.pojo.fo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author yurisu
 * @description 短信验证码登录
 * @date 2024/6/25 21:19:34
 */
@Data
@Schema(title = "短信验证码登录查询对象")
public class SmsLoginQuery {

    @NotNull(message = "国际冠字码不能为空")
    @Schema(title = "国际冠字码")
    private Integer cid;

    @NotNull(message = "手机号码不能为空")
    @Schema(title = "手机号码")
    private Long tel;

    @NotNull(message = "短信验证码不能为空")
    @Schema(title = "短信验证码", description = "timeout 为 5min")
    private Integer code;

    @NotBlank(message = "登录来源不能为空")
    @Schema(title = "登录来源", description = "main_web：独立登录页 main_mini：小窗登录")
    private String source;

    @NotBlank(message = "captcha_key不能为空")
    @Schema(title = "短信登录 token")
    private String captcha_key;

    @Schema(title = "跳转url", description = "默认为 https://www.bilibili.com")
    private String go_url;

    @Schema(title = "是否记住登录", description = " true：记住登录 false：不记住登录")
    private Boolean keep;
}
