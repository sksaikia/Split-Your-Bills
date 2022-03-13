package com.example.splityourbills.response.transaction;

import com.example.splityourbills.entity.Transaction;
import com.example.splityourbills.entity.TransactionDetails;

import java.util.Date;

public class TransactionResponse {
    private Long transactionId;
    private Long spaceId;
    private String transactionName;
    private String transactionDescription;
    private Date lastUpdated;

    public TransactionResponse() {
    }

    public TransactionResponse(Transaction transaction) {
        this.transactionId = transaction.getTransactionId();
        this.spaceId = transaction.getSpaceId();
        this.transactionName = transaction.getTransactionName();
        this.transactionDescription = transaction.getTransactionDescription();
        this.lastUpdated = transaction.getLastUpdated();
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public TransactionResponse(Long transactionId, Long spaceId, String transactionName, String transactionDescription, Date lastUpdated) {
        this.transactionId = transactionId;
        this.spaceId = spaceId;
        this.transactionName = transactionName;
        this.transactionDescription = transactionDescription;
        this.lastUpdated = lastUpdated;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }
}
