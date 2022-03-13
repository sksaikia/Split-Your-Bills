package com.example.splityourbills.service.interfaces;

import com.example.splityourbills.dto.transactiondetails.TransactionDetailsDTO;
import com.example.splityourbills.response.transaction.TransactionResponse;
import com.example.splityourbills.response.transactionDetails.AddTransactionDetailResponse;
import com.example.splityourbills.response.transactionDetails.GetAllTransactionResponse;
import com.example.splityourbills.response.transactionDetails.TransactionDetailsResponse;

import java.util.List;

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
    AddTransactionDetailResponse addNewTransactionDetail(List<TransactionDetailsDTO> transactionDetailsDTO);
    GetAllTransactionResponse getAllTXNResponseBySpaceId(Long spaceId);
    GetAllTransactionResponse getAllTXNByMemberId(Long userId);
    GetAllTransactionResponse getAllTXNByInviteId(Long inviteId);
    GetAllTransactionResponse getAllTxnByTxnId(Long txnID);
    TransactionDetailsResponse getTXNByTXNDetailsID(Long txnDetailsID);
    GetAllTransactionResponse getAllTXNBySpaceAndMemberID(Long spaceId,Long userId);
    TransactionDetailsResponse updateTXNDetailsById(Long txnDetailsID,TransactionDetailsDTO transactionDetailsDTO);
    Boolean deleteTXNDetailsById(Long txnDetailsID);
}
