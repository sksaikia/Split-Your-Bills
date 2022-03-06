package com.example.splityourbills.service.interfaces;

import com.example.splityourbills.dto.transactiondetails.TransactionDetailsDTO;
import com.example.splityourbills.response.transactionDetails.GetAllTransactionResponse;
import com.example.splityourbills.response.transactionDetails.TransactionDetailsResponse;

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
public interface TransactionDetailsService {
    TransactionDetailsResponse addNewTransactionDetail(TransactionDetailsDTO transactionDetailsDTO);
    GetAllTransactionResponse getAllTXNResponseBySpaceId(Long spaceId);
    GetAllTransactionResponse getAllTXNByMemberId(Long userId);
    TransactionDetailsResponse getTxnByTxnId(Long txnID);
    GetAllTransactionResponse getAllTXNByTXNDetailsID(Long txnDetailsID);
    GetAllTransactionResponse getAllTXNBySpaceAndMemberID(Long spaceId,Long userId);
    TransactionDetailsResponse updateTXNDetailsById();
    Boolean deleteTXNDetailsById();
}
