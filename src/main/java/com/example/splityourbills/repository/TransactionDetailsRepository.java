package com.example.splityourbills.repository;


import com.example.splityourbills.entity.Transaction;
import com.example.splityourbills.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
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
 * **/
@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {
 //   Optional<List<TransactionDetails>> findBySpaceId(Long spaceId);
    Optional<List<TransactionDetails>> findByPersonId(Long personId);
    Optional<List<TransactionDetails>> findByInviteId(Long inviteId);
    Optional<List<TransactionDetails>> findByTransactionID(Long transactionId);
 //   Optional<List<TransactionDetails>> findBYSpaceIdAndPersonId(Long spaceId, Long personId);
    Optional<TransactionDetails> findByTransactionDetailsId(Long transactionDetailsId);
}