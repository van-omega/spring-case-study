package com.example.casestudy.exception.custom;

public class DuplicateException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DuplicateException(String message) {
        super(message);
    }

    public DuplicateException(String message, Exception e){
        super(message);
    }
}
