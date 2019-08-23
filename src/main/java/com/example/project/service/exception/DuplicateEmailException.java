package com.example.project.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = DuplicateEmailException.DEFAULT_MESSAGE)
public class DuplicateEmailException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "Duplicate email";

    public DuplicateEmailException() { super(DEFAULT_MESSAGE);}

    public DuplicateEmailException(String message) {
        super(message);
    }

    public DuplicateEmailException(Throwable cause) {
        super(cause);
    }

    public DuplicateEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
