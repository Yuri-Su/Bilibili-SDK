package com.yuchang.bilibili.pojo.dto.login;

import com.yuchang.bilibili.pojo.dto.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author yurisu
 * @description 国际冠字码实体类
 * @date 2024/6/22 23:37:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(title = "国际冠字码")
public class CountryDTO extends Response {

    @Schema(title = "数据本体")
    private CountryDataDTO data;

    @Data
    @Schema(title = "国际冠字码信息")
    public static class CountryDataDTO {

        @Schema(title = "常用国家&地区")
        private List<CountryCommonDTO> common;

        @Schema(title = "其他国家&地区")
        private List<CountryCommonDTO> others;

    }

    @Data
    @Schema(title = "国家&地区信息")
    private static class CountryCommonDTO {

        @Schema(title = "国际代码值")
        private Integer id;

        @Schema(title = "国家&地区名")
        private String cname;

        @Schema(title = "国家&地区区号")
        private String country_id;

    }
}
