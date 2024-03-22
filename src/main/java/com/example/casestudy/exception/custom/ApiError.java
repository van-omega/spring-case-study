package com.example.casestudy.exception.custom;


public class ApiError {
    private String status;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getMessage(){
        return this.message;
    }

    public String getStatus(){
        return this.status;
    }
}
