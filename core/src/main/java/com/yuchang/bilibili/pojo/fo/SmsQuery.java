package com.yuchang.bilibili.pojo.fo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author yurisu
 * @description 短信验证码查询对象
 * @date 2024/6/24 21:03:15
 */
@Data
public class SmsQuery {

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
     * 登录来源
     * <ul>
     *     <li>main_web：独立登录页
     *     <li>main_mini：小窗登录
     * </ul>
     */
    @NotBlank(message = "登录来源不能为空")
    private String source;

    /**
     * 登录 API token
     */
    @NotBlank(message = "登录 API token不能为空")
    private String token;

    /**
     * 在申请 captcha 验证码接口处获取
     */
    @NotBlank(message = "极验 challenge不能为空")
    private String challenge;

    /**
     * 极验 result 极验验证后得到
     */
    @NotBlank(message = "极验 result不能为空")
    private String validate;

    /**
     * 极验 result +|jordan 极验验证后得到
     */
    @NotBlank(message = "极验 result不能为空")
    private String seccode;

}
