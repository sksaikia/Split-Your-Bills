package com.example.splityourbills.dto.transactiondetails;

public class TransactionDetailsDTO {
    private Long transactionId;
    private Long personId;
    private Long inviteId;
    private Long amount;
    private Long payableAmount;

    public Long getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Long payableAmount) {
        this.payableAmount = payableAmount;
    }

    public TransactionDetailsDTO() {
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

    public TransactionDetailsDTO(Long transactionId, Long personId, Long inviteId, Long amount, Long payableAmount) {
        this.transactionId = transactionId;
        this.personId = personId;
        this.inviteId = inviteId;
        this.amount = amount;
        this.payableAmount = payableAmount;
    }
}
