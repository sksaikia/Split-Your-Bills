package com.example.splityourbills.response.transactionDetails;

import java.util.Date;

public class TransactionDetailsSpaceAndMemberResponse {
    private Long transactionDetailId;
    private Long transactionId;
    private Long amount;
    private Long personId;
    private Long inviteId;
    private Date lastUpdated;
    private Long spaceId;
    private String transactionName;
    private String transactionDescription;


    public Long getTransactionDetailId() {
        return transactionDetailId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getAmount() {
        return amount;
    }

    public Long getPersonId() {
        return personId;
    }

    public Long getInviteId() {
        return inviteId;
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

    public TransactionDetailsSpaceAndMemberResponse(Long transactionDetailId, Long transactionId, Long amount,
                                                    Long personId, Long inviteId,  Date lastUpdated, Long spaceId, String transactionName,
                                                    String transactionDescription) {
        this.transactionDetailId = transactionDetailId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.personId = personId;
        this.inviteId = inviteId;
        this.spaceId = spaceId;
        this.transactionName = transactionName;
        this.transactionDescription = transactionDescription;
        this.lastUpdated = lastUpdated;
    }
}
