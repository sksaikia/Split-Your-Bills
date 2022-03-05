package com.example.splityourbills.exception.handler;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    // customizing timestamp serialization format
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
//    private Date timestamp;

    private int code;

    private boolean success;

    private String status;

    private String message;

    private String stackTrace;

    private Object data;
    /**
     * DataCode is used to determine whether it is a 404 error or no data found error,
     * we set in the CustomControllerAdvice Method,
     * Default value 0 - Do nothing
     * 1 - No data availble for that particular table
     * */
    private int dataCode;

    public int getDataCode() {
        return dataCode;
    }

    public void setDataCode(int dataCode) {
        this.dataCode = dataCode;
    }

    public ErrorResponse() {
    //    timestamp = new Date();
        dataCode = 0;
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message
    ) {
        this();

        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message,
            String stackTrace
    ) {
        this(
                httpStatus,
                message
        );

        this.stackTrace = stackTrace;
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message,
            String stackTrace,
            Object data
    ) {
        this(
                httpStatus,
                message,
                stackTrace
        );

        this.data = data;
    }

    public ErrorResponse(HttpStatus httpStatus,
                         String message,
                         String stackTrace,
                         Boolean success) {
        this(
                httpStatus,
                message,
                stackTrace
        );

        this.success = success;
    }

    public ErrorResponse(HttpStatus httpStatus,
                         String message,
                         String stackTrace,
                         Boolean success,
                         int dataCode) {
        this(
                httpStatus,
                message,
                stackTrace,
                success
        );
        this.dataCode = dataCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }



    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}