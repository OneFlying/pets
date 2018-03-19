package com.guo.pets.exception;

import org.apache.commons.lang.StringUtils;

public class PetsException extends Exception{
    protected Integer errorCode = 1;

    public PetsException(String message) {
        super(message);
    }

    public PetsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PetsException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public PetsException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public PetsException(int errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return StringUtils.isEmpty(super.getMessage()) ? ErrorCode.valueOf(errorCode) : super.getMessage();
    }
}
