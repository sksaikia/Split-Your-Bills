package com.example.splityourbills.response.transaction;

import java.util.Date;

public class TransactionResponse {
    private Long transactionId;
    private Long spaceId;
    private String transactionName;
    private String transactionDescription;
    private Date lastUpdated;

    public TransactionResponse() {
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
