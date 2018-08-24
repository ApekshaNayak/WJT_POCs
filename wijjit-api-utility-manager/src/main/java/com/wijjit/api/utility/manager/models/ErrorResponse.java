package com.wijjit.api.utility.manager.models;

public class ErrorResponse implements IApiResponse{
    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
