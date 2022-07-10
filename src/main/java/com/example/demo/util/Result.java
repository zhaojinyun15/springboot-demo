package com.example.demo.util;

import lombok.Data;

@Data
public class Result<T> {
    private Boolean status;
    private String errorMessage;
    private String errorCode;
    private Boolean readOnly;
    private T data;
}
