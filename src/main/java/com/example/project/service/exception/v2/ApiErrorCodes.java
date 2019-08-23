package com.example.project.service.exception.v2;

import org.springframework.http.HttpStatus;

public class ApiErrorCodes {
    public enum ApiErrorCode {
        invalidId("test_001", "Invalid Id", HttpStatus.BAD_REQUEST.value()),;


        private final String code;
        private final String message;
        private final int status;
        ApiErrorCode(String code, String message, int status) {
            this.code = code;
            this.message = message;
            this.status = status;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public int getStatus() {
            return status;
        }
    }
}
