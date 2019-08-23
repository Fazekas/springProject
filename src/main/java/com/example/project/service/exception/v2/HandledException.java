package com.example.project.service.exception.v2;

import com.example.project.service.exception.v2.ApiErrorCodes.ApiErrorCode;
public class HandledException extends ApiException {

    public HandledException (ApiErrorCode code) {
        super(code.getMessage());
    }
}
