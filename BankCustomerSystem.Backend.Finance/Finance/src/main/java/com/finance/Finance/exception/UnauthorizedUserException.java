package com.finance.Finance.exception;

import com.finance.Finance.common.ErrorResponseApisEnum;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedUserException extends RuntimeException{
    private Integer errorCode;
    private String title;
    private String developerMessage;
    public UnauthorizedUserException(String message, Integer errorCode){
        super(message);
        this.title = "Unauthorized";
        this.errorCode = errorCode;
        this.developerMessage = "";
    }

    public UnauthorizedUserException(ErrorResponseApisEnum errorEnum, String developerMessage){
        super(errorEnum.getMessage());
        this.errorCode = errorEnum.getErrorCode();
        this.title = errorEnum.getTitle();
        this.developerMessage = developerMessage;
    }
}
