package com.shahian.mapstruct.exception;

public class ResourceNotFoundException extends RuntimeException{
    private static final Long serialVersionUID = 1L;
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
