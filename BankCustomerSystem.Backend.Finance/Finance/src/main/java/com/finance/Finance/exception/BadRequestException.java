package com.finance.Finance.exception;

import com.finance.Finance.common.ErrorResponseApisEnum;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Data
public class BadRequestException extends RuntimeException {
    private Integer errorCode;
    private String title;
    private String developerMessage;


    public BadRequestException(String title, String message, Integer errorCode){
        super(message);
        this.title = title;
        this.errorCode = errorCode;
    }
    public BadRequestException(ErrorResponseApisEnum errorEnum){
        super(errorEnum.getMessage());
        this.errorCode = errorEnum.getErrorCode();
        this.title = errorEnum.getTitle();
        this.developerMessage = errorEnum.getDeveloperMessage();
    }
    public BadRequestException(ErrorResponseApisEnum errorEnum, String developerMessage){
        super(errorEnum.getMessage());
        this.errorCode = errorEnum.getErrorCode();
        this.title = errorEnum.getTitle();
        this.developerMessage = developerMessage;
    }

}
