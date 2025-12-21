package com.springtechie.exceptions;

public class InvalidSalaryException extends RuntimeException {

    public InvalidSalaryException(String msg) {
        super(msg);
    }
}
