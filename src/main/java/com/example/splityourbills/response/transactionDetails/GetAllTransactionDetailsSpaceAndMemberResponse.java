package com.example.splityourbills.response.transactionDetails;


import java.util.List;

public class GetAllTransactionDetailsSpaceAndMemberResponse {
    private Integer totalTransactions;
    private List<TransactionDetailsSpaceAndMemberResponse> transactionDetailsResponse;

    public GetAllTransactionDetailsSpaceAndMemberResponse(Integer totalTransactions, List<TransactionDetailsSpaceAndMemberResponse> transactionDetailsResponse) {
        this.totalTransactions = totalTransactions;
        this.transactionDetailsResponse = transactionDetailsResponse;
    }

    public Integer getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(Integer totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public List<TransactionDetailsSpaceAndMemberResponse> getTransactionDetailsResponse() {
        return transactionDetailsResponse;
    }

    public void setTransactionDetailsResponse(List<TransactionDetailsSpaceAndMemberResponse> transactionDetailsResponse) {
        this.transactionDetailsResponse = transactionDetailsResponse;
    }

    public GetAllTransactionDetailsSpaceAndMemberResponse() {
    }
}
