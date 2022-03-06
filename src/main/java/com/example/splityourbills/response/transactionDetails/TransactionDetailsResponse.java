package com.example.splityourbills.response.transactionDetails;

import java.util.Date;

public class TransactionDetailsResponse {
    private Long trasnactionDetailId;
    private Long transactionId;
    private Long personId;
    private Long inviteId;
    private Long amount;
    private Date lastUodated;

    public Long getTrasnactionDetailId() {
        return trasnactionDetailId;
    }

    public void setTrasnactionDetailId(Long trasnactionDetailId) {
        this.trasnactionDetailId = trasnactionDetailId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getInviteId() {
        return inviteId;
    }

    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getLastUodated() {
        return lastUodated;
    }

    public void setLastUodated(Date lastUodated) {
        this.lastUodated = lastUodated;
    }

    public TransactionDetailsResponse() {
    }

    public TransactionDetailsResponse(Long trasnactionDetailId, Long transactionId, Long personId, Long inviteId, Long amount, Date lastUodated) {
        this.trasnactionDetailId = trasnactionDetailId;
        this.transactionId = transactionId;
        this.personId = personId;
        this.inviteId = inviteId;
        this.amount = amount;
        this.lastUodated = lastUodated;
    }
}
