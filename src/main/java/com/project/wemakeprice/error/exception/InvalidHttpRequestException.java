package com.project.wemakeprice.error.exception;

public class InvalidHttpRequestException extends RuntimeException {
    public InvalidHttpRequestException(String strMessage) {
        super(strMessage);
    }
}
