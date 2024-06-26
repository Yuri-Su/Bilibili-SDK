package com.yuchang.bilibili.web;

import com.yuchang.bilibili.pojo.dto.SingleResponse;
import com.yuchang.bilibili.pojo.dto.captcha.CaptchaDTO;
import com.yuchang.bilibili.pojo.dto.login.CountryDTO;
import com.yuchang.bilibili.pojo.dto.login.SmsDTO;
import com.yuchang.bilibili.pojo.dto.login.SmsLoginDTO;
import com.yuchang.bilibili.pojo.fo.SmsLoginQuery;
import com.yuchang.bilibili.pojo.fo.SmsQuery;
import com.yuchang.bilibili.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author yurisu
 * @description 用户登录
 * @date 2024/6/20 22:24:00
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/captcha")
    public SingleResponse<CaptchaDTO> captcha() {
        return SingleResponse.of(userService.findCaptcha());
    }

    @GetMapping(value = "/country")
    public SingleResponse<CountryDTO> country() {
        return SingleResponse.of(userService.findCountry());
    }

    @PostMapping(value = "/sms/send")
    public SingleResponse<SmsDTO> sendSMS(@RequestBody @Validated SmsQuery smsQuery) {
        return SingleResponse.of(userService.sendSms(smsQuery));
    }

    @PostMapping(value = "/sms/login")
    public SingleResponse<SmsLoginDTO> login(@RequestBody @Validated SmsLoginQuery smsLoginQuery) {
        return SingleResponse.of(userService.smsLogin(smsLoginQuery));
    }
}
