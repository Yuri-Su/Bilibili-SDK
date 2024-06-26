package com.yuchang.bilibili.service.impl;

import com.yuchang.bilibili.common.exception.BilibiliException;
import com.yuchang.bilibili.pojo.dto.captcha.CaptchaDTO;
import com.yuchang.bilibili.pojo.dto.login.CountryDTO;
import com.yuchang.bilibili.pojo.dto.login.SmsDTO;
import com.yuchang.bilibili.pojo.dto.login.SmsLoginDTO;
import com.yuchang.bilibili.pojo.fo.SmsLoginQuery;
import com.yuchang.bilibili.pojo.fo.SmsQuery;
import com.yuchang.bilibili.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author yurisu
 * @description 登录领域服务实现类
 * @date 2024/6/20 23:16:40
 */
@Component
@Slf4j
public class UserServiceImpl implements UserService {

    private final RestClient restClient;

    private final ResponseErrorHandler responseErrorHandler;

    private final static String DEFAULT_BASE_URL = "https://passport.bilibili.com";

    private static class BilibiliResponseErrorHandler implements ResponseErrorHandler {

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            return response.getStatusCode().isError();
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            if (response.getStatusCode().isError()) {
                int statusCode = response.getStatusCode().value();
                String statusText = response.getStatusText();
                String message = StreamUtils.copyToString(response.getBody(), java.nio.charset.StandardCharsets.UTF_8);
                log.warn(String.format("[%s] %s - %s", statusCode, statusText, message));
                throw new BilibiliException(statusCode, statusText);
            }
        }

    }

    public UserServiceImpl() {
        this(DEFAULT_BASE_URL);
    }

    public UserServiceImpl(String baseUrl) {
        this(baseUrl, RestClient.builder());
    }

    public UserServiceImpl(String baseUrl, RestClient.Builder restClientBuilder) {
        this.responseErrorHandler = new BilibiliResponseErrorHandler();
        Consumer<HttpHeaders> defaultHeaders = headers -> {
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        };
        this.restClient = restClientBuilder.baseUrl(baseUrl).defaultHeaders(defaultHeaders).build();
    }

    @Override
    public CaptchaDTO findCaptcha() {
        return restClient
                .get()
                .uri("/x/passport-login/captcha?source=main_web")
                .retrieve()
                .body(CaptchaDTO.class);
    }

    @Override
    public CountryDTO findCountry() {
        return restClient
                .get()
                .uri("/web/generic/country/list")
                .retrieve()
                .body(CountryDTO.class);
    }

    @Override
    public SmsDTO sendSms(SmsQuery smsQuery) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("cid", smsQuery.getCid());
        params.add("tel", smsQuery.getTel());
        params.add("source", smsQuery.getSource());
        params.add("token", smsQuery.getToken());
        params.add("challenge", smsQuery.getChallenge());
        params.add("validate", smsQuery.getValidate());
        params.add("seccode", smsQuery.getSeccode());
        return restClient.post()
                .uri("/x/passport-login/web/sms/send")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(params)
                .retrieve()
                .onStatus(responseErrorHandler)
                .body(SmsDTO.class);
    }

    @Override
    public SmsLoginDTO smsLogin(SmsLoginQuery smsLoginQuery) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("cid", smsLoginQuery.getCid());
        params.add("tel", smsLoginQuery.getTel());
        params.add("code", smsLoginQuery.getCode());
        params.add("source", smsLoginQuery.getSource());
        params.add("captcha_key", smsLoginQuery.getCaptcha_key());
        params.add("go_url", smsLoginQuery.getGo_url());
        params.add("keep", smsLoginQuery.getKeep());
        return restClient.post()
                .uri("/x/passport-login/web/login/sms")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(params)
                .retrieve()
                .onStatus(responseErrorHandler)
                .body(SmsLoginDTO.class);
    }

}
