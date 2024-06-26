package com.yuchang.bilibili.common.exception;

/**
 * @author yurisu
 * @description 异常信息
 * @date 2024/6/24 21:40:26
 */
public class BilibiliException extends BaseException {

    private static final Integer DEFAULT_ERR_CODE = 400;

    public BilibiliException(String errMessage) {
        super(DEFAULT_ERR_CODE, errMessage);
    }

    public BilibiliException(Integer errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public BilibiliException(String errMessage, Throwable e) {
        super(DEFAULT_ERR_CODE, errMessage, e);
    }

    public BilibiliException(Integer errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }

}
