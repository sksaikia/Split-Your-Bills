package com.example.splityourbills.repository;


import com.example.splityourbills.entity.Transaction;
import com.example.splityourbills.entity.TransactionDetails;
import com.example.splityourbills.response.transactionDetails.TransactionDetailsSpaceAndMemberResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * add txn details - list of txn s - get counts from here
 * getAll transactions by spaceId
 * get all txn by member ID
 * get txn by txn ID
 * get txn by txn details ID
 * get all txn by space and member ID
 * update txn by id
 * delete txn by id
 **/
@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {

    @Query(value = "SELECT new com.example.splityourbills.response.transactionDetails.TransactionDetailsSpaceAndMemberResponse( td.transactionDetailsId,td.transactionID,td.amount,td.personId,td.inviteId," +
            "td.lastUpdated,t.spaceId,t.transactionName,t.transactionDescription , s.spaceName, s.spaceDescription, us.userName , inv.inviteName)" +
            "FROM TransactionDetails td " +
            "join Transaction t on " +
            "td.transactionID=t.transactionId join Space s on t.spaceId=s.spaceId join User us on td.personId=us.userId join Invite inv on td.inviteId=inv.inviteId where t.spaceId=?1")
    Optional<List<TransactionDetailsSpaceAndMemberResponse>> findBySpaceId(Long spaceId);

    Optional<List<TransactionDetails>> findByPersonId(Long personId);

    Optional<List<TransactionDetails>> findByInviteId(Long inviteId);

    Optional<List<TransactionDetails>> findByTransactionID(Long transactionId);

    //TODO fix this
    @Query(value = "SELECT new com.example.splityourbills.response.transactionDetails.TransactionDetailsSpaceAndMemberResponse( td.transactionDetailsId,td.transactionID,td.amount,td.personId,td.inviteId," +
        "td.lastUpdated,t.spaceId,t.transactionName,t.transactionDescription , s.spaceName, s.spaceDescription, us.userName, inv.inviteName)" +
        "FROM TransactionDetails td " +
        "join Transaction t on " +
        "td.transactionID=t.transactionId join Space s on t.spaceId=s.spaceId join User us on td.personId=us.userId join Invite inv on td.inviteId=inv.inviteId where t.spaceId=?1 and td.personId=?2")
    Optional<List<TransactionDetailsSpaceAndMemberResponse>> findBYSpaceIdAndPersonId(Long spaceId, Long personId);

    Optional<TransactionDetails> findByTransactionDetailsId(Long transactionDetailsId);
}