package com.auggpt.exception;

public enum ErrorCode implements IErrorCode{

    METHOD_NOT_IMPLEMENT(5001,"Method or function not implemented.");


    private final int code;
    private final String msg;
    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
