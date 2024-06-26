package com.yuchang.bilibili.pojo.dto.login;

import lombok.Data;

import java.util.List;

/**
 * @author yurisu
 * @description 国际冠字码实体类
 * @date 2024/6/22 23:37:14
 */
@Data
public class CountryDTO {

    /**
     * 0：成功
     */
    private Integer code;

    /**
     * 数据本体
     */
    private CountryDataDTO data;

    @Data
    private static class CountryDataDTO {

        /**
         * 常用国家&地区
         */
        private List<CountryCommonDTO> common;

        /**
         * 其他国家&地区
         */
        private List<CountryCommonDTO> others;

    }

    @Data
    private static class CountryCommonDTO {

        /**
         * 国际代码值
         */
        private Integer id;

        /**
         * 国家&地区名
         */
        private String cname;

        /**
         * 国家&地区区号
         */
        private String country_id;

    }
}
