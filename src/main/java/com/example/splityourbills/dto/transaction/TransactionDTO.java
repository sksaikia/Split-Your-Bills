package com.example.splityourbills.dto.transaction;

public class TransactionDTO {
    private Long SpaceId;
    private String transactionName;
    private String transactionDescription;

    public Long getSpaceId() {
        return SpaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.SpaceId = spaceId;
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
        this.SpaceId = SpaceId;
        this.transactionName = transactionName;
        this.transactionDescription = transactionDescription;
    }
}
