package com.yuchang.bilibili.sign;

import com.yuchang.bilibili.config.SignProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yurisu
 * @description APP API 签名算法工具类
 * @date 2024/6/17 23:19:20
 */
@Slf4j
@Component
public class AppSigner implements ApplicationContextAware {

    private static final String APP_KEY = "appkey";

    private static SignProperties signProperties;

    /**
     * APP API 签名算法
     *
     * @param params 请求参数字典
     * @return 签名后的字符串
     */
    public static String appSign(Map<String, String> params) {
        // 为请求参数进行 APP 签名
        params.put(APP_KEY, signProperties.getAPP_KEY());
        // 按照 key 重排参数
        Map<String, String> sortedParams = new TreeMap<>(params);
        // 序列化参数
        StringBuilder queryBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedParams.entrySet()) {
            if (!queryBuilder.isEmpty()) {
                queryBuilder.append('&');
            }
            queryBuilder
                    .append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8))
                    .append('=')
                    .append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }
        return generateMD5(queryBuilder.append(signProperties.getAPP_SEC()).toString());
    }

    /**
     * MD5加密
     *
     * @param input 输入
     * @return 加密后的字符串
     */
    private static String generateMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("MD5加密异常: {}", e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        signProperties = applicationContext.getBean(SignProperties.class);
    }
}
