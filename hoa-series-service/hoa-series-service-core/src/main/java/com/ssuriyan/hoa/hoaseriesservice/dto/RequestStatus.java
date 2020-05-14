package com.ssuriyan.hoa.hoaseriesservice.dto;

public class RequestStatus {

    public enum Status {
        SUCCESS, ERROR
    }

    private Status status;
    private String message;

    public RequestStatus() {
    }

    public RequestStatus(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
