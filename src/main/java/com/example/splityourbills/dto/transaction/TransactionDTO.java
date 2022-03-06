package com.example.splityourbills.dto.transaction;

public class TransactionDTO {
    private Long spaceId;
    private String transactionName;
    private String transactionDescription;

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public TransactionDTO() {
    }

    public TransactionDTO(Long SpaceId, String transactionName, String transactionDescription) {
        this.spaceId = SpaceId;
        this.transactionName = transactionName;
        this.transactionDescription = transactionDescription;
    }
}
