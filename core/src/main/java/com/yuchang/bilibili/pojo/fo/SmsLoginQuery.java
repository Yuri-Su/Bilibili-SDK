package com.yuchang.bilibili.pojo.fo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author yurisu
 * @description 短信验证码登录
 * @date 2024/6/25 21:19:34
 */
@Data
public class SmsLoginQuery {

    /**
     * 国际冠字码
     */
    @NotNull(message = "国际冠字码不能为空")
    private Integer cid;

    /**
     * 手机号码
     */
    @NotNull(message = "手机号码不能为空")
    private Long tel;

    /**
     * 短信验证码, timeout 为 5min
     */
    @NotNull(message = "短信验证码不能为空")
    private Integer code;

    /**
     * 登录来源
     * <ul>
     *     <li>main_web：独立登录页
     *     <li>main_mini：小窗登录
     * </ul>
     */
    @NotBlank(message = "登录来源不能为空")
    private String source;

    /**
     * 短信登录 token
     */
    @NotBlank(message = "captcha_key不能为空")
    private String captcha_key;

    /**
     * 跳转url, 默认为 <a href="https://www.bilibili.com">哔哩哔哩</a>
     */
    private String go_url;

    /**
     * 是否记住登录
     * true：记住登录
     * false：不记住登录
     */
    private Boolean keep;
}
