package com.yuchang.bilibili.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseException extends RuntimeException {

    private Integer errCode;

    public BaseException(String errMessage) {
        super(errMessage);
    }

    public BaseException(Integer errCode, String errMessage) {
        super(errMessage);
        this.errCode = errCode;
    }

    public BaseException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public BaseException(Integer errCode, String errMessage, Throwable e) {
        super(errMessage, e);
        this.errCode = errCode;
    }
}