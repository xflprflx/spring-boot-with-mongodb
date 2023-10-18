package com.xflprflx.springwithmongo.services.exceptions;

public class ResourceNotFoundException extends  RuntimeException {
    private static final long serialVersionUid = 1L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
