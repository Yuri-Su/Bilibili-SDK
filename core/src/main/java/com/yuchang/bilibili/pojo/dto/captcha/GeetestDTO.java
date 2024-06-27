package com.yuchang.bilibili.pojo.dto.captcha;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 极验captcha数据
 */
@Data
public class GeetestDTO {

    @Schema(title = "极验id", description = "一般为固定值")
    private String gt;

    @Schema(title = "极验KEY", description = "由B站后端产生用于人机验证")
    private String challenge;

}