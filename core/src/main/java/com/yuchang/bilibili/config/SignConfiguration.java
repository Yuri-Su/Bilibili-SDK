package com.yuchang.bilibili.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author yurisu
 * @description 签名配置类
 * @date 2024/6/20 21:44:40
 */
@Configuration
@EnableConfigurationProperties(SignProperties.class)
public class SignConfiguration {
}
