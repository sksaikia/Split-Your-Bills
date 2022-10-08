package com.example.splityourbills.response.transactionDetails;

import com.example.splityourbills.common.Constants;
import com.example.splityourbills.entity.TransactionDetails;
import com.example.splityourbills.response.auth.UserResponse;
import com.example.splityourbills.response.invite.InviteResponse;
import com.example.splityourbills.response.transaction.TransactionResponse;
import org.springframework.lang.Nullable;

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
    private String spaceName;
    private String spaceDescription;
    private String userName;
    private String inviteName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInviteName() {
        return inviteName;
    }

    public void setInviteName(String inviteName) {
        this.inviteName = inviteName;
    }

    public void setTransactionDetailId(Long transactionDetailId) {
        this.transactionDetailId = transactionDetailId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
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

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceDescription() {
        return spaceDescription;
    }

    public void setSpaceDescription(String spaceDescription) {
        this.spaceDescription = spaceDescription;
    }


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
                                                    Long personId, Long inviteId, Date lastUpdated, Long spaceId, String transactionName,
                                                    String transactionDescription, String spaceName,
                                                    String spaceDescription, String userName) {
        this.transactionDetailId = transactionDetailId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.personId = personId;
        this.inviteId = inviteId;
        this.spaceId = spaceId;
        this.transactionName = transactionName;
        this.transactionDescription = transactionDescription;
        this.lastUpdated = lastUpdated;
        this.spaceName = spaceName;
        this.spaceDescription = spaceDescription;
        this.userName = userName;
        this.inviteName = inviteName;
    }
}
