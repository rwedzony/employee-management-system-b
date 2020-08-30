package com.rafwedz.employee.exceptions;

public class EMSCustomException extends RuntimeException {
    public EMSCustomException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }
    public EMSCustomException(String exMessage) {
        super(exMessage);
    }
}
