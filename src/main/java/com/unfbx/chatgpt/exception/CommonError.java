package com.unfbx.chatgpt.exception;



public enum CommonError implements IError {
    MESSAGE_NOT_NUL(500, "Message  Cannot be empty "),
    API_KEYS_NOT_NUL(500, "API KEYS  Cannot be empty "),
    NO_ACTIVE_API_KEYS(500, " No available API KEYS"),
    SYS_ERROR(500, " The system is busy "),
    PARAM_ERROR(501, " Parameter exception "),
    RETRY_ERROR(502, " Request exception ， Please try again ~"),
    // Official Error Code List : https://platform.openai.com/docs/guides/error-codes/api-errors
    OPENAI_AUTHENTICATION_ERROR(401, " Invalid authentication / Provided  API  The key is incorrect / You must be a member of the organization to use  API"),
    OPENAI_LIMIT_ERROR(429 , " Reaching the requested rate limit / You have exceeded the current quota ， Please check your plan and billing details / The engine is currently overloaded ， Please try again later "),
    OPENAI_SERVER_ERROR(500, " The server encountered an error while processing your request "),
    ;


    private final int code;
    private final String msg;

    CommonError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String msg() {
        return this.msg;
    }

    @Override
    public int code() {
        return this.code;
    }
}
