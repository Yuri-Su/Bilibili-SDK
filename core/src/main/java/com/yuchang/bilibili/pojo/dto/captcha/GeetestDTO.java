package com.yuchang.bilibili.pojo.dto.captcha;

import lombok.Data;

/**
 * 极验captcha数据
 */
@Data
public class GeetestDTO {

    /**
     * 极验id 一般为固定值
     */
    private String gt;

    /**
     * 极验KEY	由B站后端产生用于人机验证
     */
    private String challenge;

}