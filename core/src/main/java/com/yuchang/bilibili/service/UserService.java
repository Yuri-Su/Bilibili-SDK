package com.yuchang.bilibili.service;

import com.yuchang.bilibili.pojo.dto.captcha.CaptchaDTO;
import com.yuchang.bilibili.pojo.dto.login.CountryDTO;
import com.yuchang.bilibili.pojo.dto.login.SmsDTO;
import com.yuchang.bilibili.pojo.dto.login.SmsLoginDTO;
import com.yuchang.bilibili.pojo.fo.SmsLoginQuery;
import com.yuchang.bilibili.pojo.fo.SmsQuery;

/**
 * @author yurisu
 * @description 用户登录领域
 * @date 2024/6/20 23:10:19
 */
public interface UserService {

    /**
     * 获取人机登录信息
     *
     * @return 人机登录信息
     */
    CaptchaDTO findCaptcha();

    /**
     * 获取国际冠字码
     * @return 国际冠字码
     */
    CountryDTO findCountry();

    /**
     * 发送短信验证码 web端
     * @return 短信验证码
     */
    SmsDTO sendSms(SmsQuery smsQuery);

    /**
     * 使用短信验证码登录 web端
     * @return 短信验证码返回结果
     */
    SmsLoginDTO smsLogin(SmsLoginQuery smsLoginQuery);
}
