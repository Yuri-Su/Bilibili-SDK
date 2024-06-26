package com.yuchang.bilibili.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yurisu
 * @description 客户端签名与鉴权属性
 * @date 2024/6/17 22:53:43
 */
@Data
@ConfigurationProperties(prefix = "com.yuchang.bilibili.sign")
public class SignProperties {

    /**
     * 部分客户端专用的 REST API 存在基于参数签名的鉴权，需要使用规定的{@code APP_KEY}及其对应的{@code APP_SEC}与原始请求参数进行签名计算
     * <ul>
     * <li>不同 {@code APP_KEY} 对应不同的 app (如客户端、概念版、必剪、漫画、bililink等)
     * <li>不同平台同 app 也会存在不同的 {@code APP_KEY} (如安卓端、ios端、TV端等)
     * <li>同平台同 app 下不同功能也会存在不同的 {@code APP_KEY}（如登录专用、取流专用等）
     * <li>不同版本的客户端的 {@code APP_KEY} 也可能不同
     * </ul>
     * @see <a href="https://socialsisteryi.github.io/bilibili-API-collect/docs/misc/sign/APPKey.html">APP KEY参考文档</a>
     */
    private String APP_KEY;

    /**
     * {@code APP_KEY} 与 {@code APP_SEC} 一一对应
     */
    private String APP_SEC;
}
