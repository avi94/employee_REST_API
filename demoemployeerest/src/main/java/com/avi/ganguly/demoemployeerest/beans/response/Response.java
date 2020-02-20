package com.avi.ganguly.demoemployeerest.beans.response;

public class Response {
    private boolean error;
    private String message;

    public Response(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
