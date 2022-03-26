package com.example.splityourbills.entity;

import com.example.splityourbills.dto.transaction.TransactionDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private Long transactionId;

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", spaceId=" + spaceId +
                ", transactionName='" + transactionName + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", space=" + space +
                '}';
    }

    @Column(name="space_id")
    private Long spaceId;

    @Column(name="transaction_name")
    private String transactionName;

    @Column(name="transaction_description")
    private String transactionDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated",nullable = false)
    private Date lastUpdated;

//    public TransactionDetails getTransactionDetails() {
//        return transactionDetails;
//    }
//
//    public void setTransactionDetails(TransactionDetails transactionDetails) {
//        this.transactionDetails = transactionDetails;
//    }

//    @OneToMany()
//    @JoinColumn(name="transaction_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<TransactionDetails> transactionDetails;


    public List<TransactionDetails> getTransactionDetails(){
        return this.transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }


    public Transaction(TransactionDTO transactionDTO) {
        this.spaceId = transactionDTO.getSpaceId();
        this.transactionName = transactionDTO.getTransactionName();
        this.transactionDescription = transactionDTO.getTransactionDescription();
    }

    @PrePersist
    private void onCreate(){
        lastUpdated = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "space_id", referencedColumnName = "space_id",insertable = false,updatable = false)
    private Space space;

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Transaction() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

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

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }
}

