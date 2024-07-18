package com.example.sms.shared.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * This class is used as the generic API response from the application
 * @param <T>
 */
public class ApiResponse<T> {

    private T data;
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private List<String> errors;

    public ApiResponse(T data){
        this.data = data;
    }

    public ApiResponse(T data, int status, String message, List<String> errors){
        this.data = data;
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.timestamp = ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime();
    }

    public ApiResponse<T> success(){
        this.status = HttpStatus.OK.value();
        this.message = HttpStatus.OK.getReasonPhrase();
        this.timestamp = ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime();
        return this;
    }

    public ApiResponse<T> success(String message){
        this.status = HttpStatus.OK.value();
        this.message = message;
        this.timestamp = ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime();
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
