package com.wijjit.api.utility.manager.exception.handler;

import com.wijjit.api.utility.manager.controller.JwtTokenCreatorController;
import com.wijjit.api.utility.manager.controller.UserProfileManagerController;
import com.wijjit.api.utility.manager.models.ErrorResponse;
import com.wijjit.api.utility.manager.models.IApiResponse;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {JwtTokenCreatorController.class, UserProfileManagerController.class})
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<IApiResponse> handleGeneralException(Exception ex) {
        if (ex instanceof NullPointerException) {
            return new ResponseEntity<>(new ErrorResponse("Something is wrong with the data"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UncategorizedMongoDbException.class)
    public ResponseEntity<IApiResponse> handleMongoDbException(UncategorizedMongoDbException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
