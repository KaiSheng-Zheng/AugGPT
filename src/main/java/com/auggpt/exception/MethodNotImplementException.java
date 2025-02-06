package com.auggpt.exception;

import lombok.Getter;

@Getter
public class MethodNotImplementException extends RuntimeException {
    private final IErrorCode code = ErrorCode.METHOD_NOT_IMPLEMENT;
    public MethodNotImplementException() {
        super(ErrorCode.METHOD_NOT_IMPLEMENT.getMsg());
    }
}
