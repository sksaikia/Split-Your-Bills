package com.example.splityourbills.entity;


import com.example.splityourbills.dto.transactiondetails.TransactionDetailsDTO;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transaction_details")
public class TransactionDetails{
    @Override
    public String toString() {
        return "TransactionDetails{" +
                "transactionDetailsId=" + transactionDetailsId +
                ", transactionID=" + transactionID +
                ", personId=" + personId +
                ", inviteId=" + inviteId +
                ", amount=" + amount +
                ", lastUpdated=" + lastUpdated +
                ", transaction=" + transaction +
                ", user=" + user +
                ", invite=" + invite +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_details_id")
    private Long transactionDetailsId;

    @Column(name="transaction_id")
    private Long transactionID;

    @Column(name="person_id")
    private Long personId;

    @Column(name = "invite_id")
    private Long inviteId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "payable_amount")
    private Long payableAmount;

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated",nullable = false)
    private Date lastUpdated;

    public TransactionDetails(TransactionDetailsDTO transactionDTO) {
           this.transactionID =  transactionDTO.getTransactionId();
           this.personId = transactionDTO.getPersonId();
           this.inviteId = transactionDTO.getInviteId();
           this.amount = transactionDTO.getAmount();
           this.payableAmount = transactionDTO.getPayableAmount();
    }

    @PrePersist
    private void onCreate(){
        lastUpdated = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id",insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "user_id",insertable = false,updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "invite_id", referencedColumnName = "invite_id",insertable = false,updatable = false)
    private Invite invite;

    public Long getTransactionDetailsId() {
        return transactionDetailsId;
    }

    public TransactionDetails() {
    }

    public void setTransactionDetailsId(Long transactionDetailsId) {
        this.transactionDetailsId = transactionDetailsId;
    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
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

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Long payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Invite getInvite() {
        return invite;
    }

    public void setInvite(Invite invite) {
        this.invite = invite;
    }
}
