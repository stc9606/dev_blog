package com.news.dev.response;


import com.news.dev.response.dto.ErrorCode;
import com.news.dev.response.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityHandler {

    private ResponseEntity<Object> response(Object response, HttpStatus status) {

        return new ResponseEntity<>(response, status);
    }

    protected ResponseEntity<Object> success(Object body) {
        ErrorResponse response = ErrorResponse.of(ErrorCode.SUCCESS, body);
        return this.response(response, HttpStatus.OK);
    }

    protected ResponseEntity<Object> success(Object body, HttpStatus status) {
        ErrorResponse response = ErrorResponse.of(ErrorCode.SUCCESS, body);
        return this.response(response, status);
    }

    protected ResponseEntity<Object> fail(Object error, HttpStatus status) {
        return this.response(error, status);
    }

    protected ResponseEntity<Object> fail(ErrorCode code, HttpStatus status) {
        ErrorResponse response = ErrorResponse.of(code);
        return this.response(response, status);
    }

    protected ResponseEntity<Object> fail(Exception e) {
        ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return this.response(response, HttpStatus.OK);
    }

}
