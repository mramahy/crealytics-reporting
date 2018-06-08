package com.crealytics.reporting.dto.wrapper;

/*
* response wrapper for rest api calls, can handle any type of response
* */
public class Response<T> {

    T response;
    Integer code;
    String message;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
