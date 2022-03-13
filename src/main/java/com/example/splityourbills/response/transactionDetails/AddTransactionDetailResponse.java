package com.example.splityourbills.response.transactionDetails;

public class AddTransactionDetailResponse {
    private Integer success;
    private Integer failure;
    private Integer ignored;

    public AddTransactionDetailResponse() {
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getFailure() {
        return failure;
    }

    public void setFailure(Integer failure) {
        this.failure = failure;
    }

    public Integer getIgnored() {
        return ignored;
    }

    public void setIgnored(Integer ignored) {
        this.ignored = ignored;
    }

    public AddTransactionDetailResponse(Integer success, Integer failure, Integer ignored) {
        this.success = success;
        this.failure = failure;
        this.ignored = ignored;
    }
}
