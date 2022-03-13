package com.example.splityourbills.response.transactionDetails;

import com.example.splityourbills.common.Constants;
import com.example.splityourbills.entity.TransactionDetails;
import com.example.splityourbills.response.auth.UserResponse;
import com.example.splityourbills.response.invite.InviteResponse;
import com.example.splityourbills.response.transaction.TransactionResponse;

import java.util.Date;

public class TransactionDetailsResponse {
    private Long trasnactionDetailId;
    private Long transactionId;
    private TransactionResponse transaction;
    private Long personId;
    private UserResponse user;
    private Long inviteId;
    private InviteResponse invite;
    private Long amount;
    private Date lastUpdated;

    public TransactionResponse getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionResponse transaction) {
        this.transaction = transaction;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public InviteResponse getInvite() {
        return invite;
    }

    public void setInvite(InviteResponse invite) {
        this.invite = invite;
    }

    public TransactionDetailsResponse(TransactionDetails transactionDetails) {
        this.trasnactionDetailId = transactionDetails.getTransactionDetailsId();
        this.transactionId = transactionDetails.getTransactionID();
        this.personId = transactionDetails.getPersonId();
        this.inviteId = transactionDetails.getInviteId();
        this.amount = transactionDetails.getAmount();
        this.lastUpdated = transactionDetails.getLastUpdated();
        if (inviteId!= Constants.ERROR_STATE_MEMBERS)
            this.invite = new InviteResponse(transactionDetails.getInvite());
        if (personId!=Constants.ERROR_STATE_MEMBERS)
            this.user = new UserResponse(transactionDetails.getUser());
        this.transaction = new TransactionResponse(transactionDetails.getTransaction());
    }

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

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public TransactionDetailsResponse() {
    }

    public TransactionDetailsResponse(Long trasnactionDetailId, Long transactionId, Long personId, Long inviteId,
                                      Long amount, Date lastUpdated, TransactionDetails transactionDetails) {
        this.trasnactionDetailId = trasnactionDetailId;
        this.transactionId = transactionId;
        this.personId = personId;
        this.inviteId = inviteId;
        this.amount = amount;
        this.lastUpdated = lastUpdated;
        if (inviteId!= Constants.ERROR_STATE_MEMBERS)
            this.invite = new InviteResponse(transactionDetails.getInvite());
        if (personId!=Constants.ERROR_STATE_MEMBERS)
            this.user = new UserResponse(transactionDetails.getUser());
        this.transaction = new TransactionResponse(transactionDetails.getTransaction());
        System.out.println(transactionDetails.getTransaction().toString());
    }
}
