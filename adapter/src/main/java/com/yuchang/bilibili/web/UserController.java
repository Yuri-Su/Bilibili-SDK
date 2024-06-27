package com.yuchang.bilibili.web;

import com.yuchang.bilibili.pojo.dto.SingleResponse;
import com.yuchang.bilibili.pojo.dto.captcha.CaptchaDTO;
import com.yuchang.bilibili.pojo.dto.login.CaptchaKeyDTO;
import com.yuchang.bilibili.pojo.dto.login.CountryDTO;
import com.yuchang.bilibili.pojo.dto.login.SmsDTO;
import com.yuchang.bilibili.pojo.dto.login.SmsLoginDTO;
import com.yuchang.bilibili.pojo.fo.SmsLoginQuery;
import com.yuchang.bilibili.pojo.fo.SmsQuery;
import com.yuchang.bilibili.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "用户", description = "用户登录")
public class UserController {

    private final UserService userService;

    @Operation(tags = "用户", summary = "获取人机登录信息")
    @GetMapping(value = "/captcha")
    public SingleResponse<CaptchaDTO.CaptchaDataDTO> captcha() {
        CaptchaDTO captcha = userService.findCaptcha();
        return SingleResponse.of(captcha.getCode(), captcha.getMessage(), captcha.getData());
    }

    @Operation(tags = "用户", summary = "获取国际冠字码")
    @GetMapping(value = "/country")
    public SingleResponse<CountryDTO.CountryDataDTO> country() {
        CountryDTO country = userService.findCountry();
        return SingleResponse.of(country.getCode(), country.getData());
    }

    @Operation(tags = "用户", summary = "发送短信验证码 Web")
    @PostMapping(value = "/sms/send")
    public SingleResponse<CaptchaKeyDTO> sendSMS(@RequestBody @Validated SmsQuery smsQuery) {
        SmsDTO smsDTO = userService.sendSms(smsQuery);
        return SingleResponse.of(smsDTO.getCode(), smsDTO.getMessage(), smsDTO.getData());
    }

    @Operation(tags = "用户", summary = "使用短信验证码登录 Web")
    @PostMapping(value = "/sms/login")
    public SingleResponse<SmsLoginDTO.SmsLoginDataDTO> login(@RequestBody @Validated SmsLoginQuery smsLoginQuery) {
        SmsLoginDTO smsLoginDTO = userService.smsLogin(smsLoginQuery);
        return SingleResponse.of(smsLoginDTO.getCode(), smsLoginDTO.getMessage(), smsLoginDTO.getData());
    }
}
