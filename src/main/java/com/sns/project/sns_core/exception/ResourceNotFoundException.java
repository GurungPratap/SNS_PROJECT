package com.sns.project.sns_core.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     *
     * @param resource
     */
    public ResourceNotFoundException(String resource) {
        super(String.format("Resource %s not found", resource));
    }
}