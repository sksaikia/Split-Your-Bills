package com.example.splityourbills.response.transactionDetails;

import java.util.List;

public class GetAllTransactionResponse {
    private Integer totalTransactions;
    private List<TransactionDetailsResponse> transactionDetailsResponse;

    public GetAllTransactionResponse() {
    }

    public Integer getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(Integer totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public List<TransactionDetailsResponse> getTransactionDetailsResponse() {
        return transactionDetailsResponse;
    }

    public void setTransactionDetailsResponse(List<TransactionDetailsResponse> transactionDetailsResponse) {
        this.transactionDetailsResponse = transactionDetailsResponse;
    }

    public GetAllTransactionResponse(Integer totalTransactions, List<TransactionDetailsResponse> transactionDetailsResponse) {
        this.totalTransactions = totalTransactions;
        this.transactionDetailsResponse = transactionDetailsResponse;
    }
}
