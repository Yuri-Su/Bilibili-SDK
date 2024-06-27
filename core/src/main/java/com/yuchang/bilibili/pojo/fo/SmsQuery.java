package com.yuchang.bilibili.pojo.fo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author yurisu
 * @description 短信验证码查询对象
 * @date 2024/6/24 21:03:15
 */
@Data
@Schema(title = "短信验证码查询对象")
public class SmsQuery {

    @NotNull(message = "国际冠字码不能为空")
    @Schema(title = "国际冠字码")
    private Integer cid;

    @NotNull(message = "手机号码不能为空")
    @Schema(title = "手机号码")
    private Long tel;

    @NotBlank(message = "登录来源不能为空")
    @Schema(title = "登录来源", description = """
            main_web：独立登录页
            main_mini：小窗登录""")
    private String source;

    @NotBlank(message = "登录 API token不能为空")
    @Schema(title = "登录 API token")
    private String token;

    @NotBlank(message = "极验 challenge不能为空")
    @Schema(title = "challenge", description = "在申请 captcha 验证码接口处获取")
    private String challenge;

    @NotBlank(message = "极验 result不能为空")
    @Schema(title = "validate", description = "极验 result 极验验证后得到")
    private String validate;

    @NotBlank(message = "极验 result不能为空")
    @Schema(title = "seccode", description = "极验 result +|jordan 极验验证后得到")
    private String seccode;

}
