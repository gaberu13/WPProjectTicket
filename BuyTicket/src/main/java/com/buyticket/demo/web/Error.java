package com.buyticket.demo.web;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

public class Error {
    private HttpStatus status;
    private String message;
    private HashMap errors;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap getErrors() {
        return errors;
    }

    public void setErrors(HashMap errors) {
        this.errors = errors;
    }

    public Error(HttpStatus status, String message, HashMap errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
