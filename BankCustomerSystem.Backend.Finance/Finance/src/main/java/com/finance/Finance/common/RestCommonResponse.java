package com.finance.Finance.common;

import lombok.Data;

@Data
public class RestCommonResponse {

    private Boolean status;

    private Object data;

    private Integer responseCode;

    private String title;

    private String message;

    private String developerMessage;

    private String flag;

    public RestCommonResponse(Boolean status) {
        this.status = status;
        this.data = new Object();
        if (status) {
            this.responseCode = 1;
            this.title = "Success";
            this.message = "action done";
            this.developerMessage = "";
        } else {
            this.responseCode = 400;
            this.title = "Failure";
            this.message = "action not completed";
            this.developerMessage = "";
        }
    }

    public RestCommonResponse(Boolean status,  Object data) {
        this.status = status;
        this.data = data;
        if (status) {
            this.responseCode = 1;
            this.title = "Success";
            this.message = "action done";
            this.developerMessage = "";
        } else {
            this.responseCode = 400;
            this.title = "Failure";
            this.message = "action not completed";
            this.developerMessage = "";
        }
    }

    public RestCommonResponse(Boolean status, Object data, Integer responseCode, String title, String message) {
        this.status = status;
        this.data = data ;
        this.responseCode = responseCode;
        this.title = title;
        this.message = message;
        this.developerMessage = "";
    }

    public RestCommonResponse(Boolean status, Object data, Integer responseCode, String title, String message, String developerMessage) {
        this.status = status;
        this.data = data ;
        this.responseCode = responseCode;
        this.title = title;
        this.message = message;
        this.developerMessage = developerMessage;
    }

    public RestCommonResponse(Boolean status, String data, Integer responseCode, String title, String message) {
        this.status = status;
        this.data = data;
        this.responseCode = responseCode;
        this.title = title;
        this.message = message;
        this.developerMessage = "";
    }

    public RestCommonResponse(Boolean status, Boolean isFlag) {
        this.status = status;
        this.data = new Object();
        this.flag = "UNDEFINED";
        if (status) {
            this.responseCode = 1;
            this.title = "Success";
            this.message = "action done";
        } else {
            this.responseCode = 400;
            this.title = "Failure";
            this.message = "action not completed";
        }
    }
}
