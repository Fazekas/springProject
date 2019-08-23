package com.example.project.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = ApiException.DEFAULT_MESSAGE)
public class ApiException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "An Application error has occurred!";

    public ApiException() { super(DEFAULT_MESSAGE);}

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
