package com.sns.project.sns_core.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotAllowedException extends RuntimeException {

    /**
     * throw exception not allowed
     * @param user
     * @param resource
     * @param operation
     */
    public NotAllowedException(String user, String resource, String operation) {
        super(String.format("User %s is not allowed to %s resource %s",
                user, operation, resource));
    }
}