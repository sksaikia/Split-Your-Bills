package com.example.splityourbills.response.transactionDetails;

import java.util.Date;

public class TransactionDetailsBalanceResponse {
    private Long totalIn, totalOut;

    public TransactionDetailsBalanceResponse() {
    }

    public TransactionDetailsBalanceResponse(Long totalIn, Long totalOut) {
        this.totalIn = totalIn;
        this.totalOut = totalOut;
    }

    public Long getTotalIn() {
        return totalIn;
    }

    public void setTotalIn(Long totalIn) {
        this.totalIn = totalIn;
    }

    public Long getTotalOut() {
        return totalOut;
    }

    public void setTotalOut(Long totalOut) {
        this.totalOut = totalOut;
    }
}
