package com.finance.Finance.exception;

import com.finance.Finance.common.RestCommonResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestController
@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        RestCommonResponse exceptionResponse = new RestCommonResponse(false, null, 500, "Server Error", "Unexpected Server Error", ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
        RestCommonResponse exceptionResponse = new RestCommonResponse(false, null, ex.getErrorCode(), ex.getTitle(), ex.getMessage(), ex.getDeveloperMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = "";

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (errorMessage != "") {
                errorMessage += ", ";
            }
            errorMessage += error.getDefaultMessage();
        }
        RestCommonResponse exceptionResponse = new RestCommonResponse(false, null, 4000, "Validation Error", errorMessage);
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
