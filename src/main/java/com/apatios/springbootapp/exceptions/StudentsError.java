package com.apatios.springbootapp.exceptions;

import java.util.Date;

public class StudentsError {
    private String message;
    private Date timestamp;

    public StudentsError() {
    }

    public StudentsError(String message) {
        this.message = message;
        this.timestamp = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
