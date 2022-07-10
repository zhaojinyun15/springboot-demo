package com.example.demo.util;

public class ResultVo {
    public static <T> Result<T> success(T t, Boolean readOnly) {
        Result<T> result = new Result<>();
        result.setStatus(true);
        result.setReadOnly(readOnly);
        result.setData(t);
        return result;
    }

    public static Result error(String errorMessage, String errorCode) {
        Result result = new Result();
        result.setStatus(false);
        result.setErrorMessage(errorMessage);
        result.setErrorCode(errorCode);
        return result;
    }
}
