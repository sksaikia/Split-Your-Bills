package com.example.splityourbills.common;

import com.example.splityourbills.exception.handler.ErrorResponse;
import org.springframework.http.HttpStatus;

public class BaseApiResponse<DT> {
    private Boolean success;
    private DT data;
    private ErrorResponse error;

    public DT getData() {
        return data;
    }

    public void setData(DT data) {
        this.data = data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public BaseApiResponse() {
    }

    public BaseApiResponse(Boolean success, DT data, ErrorResponse error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public BaseApiResponse(Boolean success){
        this.success = success;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
