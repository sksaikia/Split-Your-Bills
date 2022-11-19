package com.example.splityourbills.service.interfaces;

import com.example.splityourbills.dto.transactiondetails.TransactionDetailsDTO;
import com.example.splityourbills.response.transaction.TransactionResponse;
import com.example.splityourbills.response.transactionDetails.*;

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
    GetAllTransactionDetailsSpaceAndMemberResponse getAllTXNResponseBySpaceId(Long spaceId);
    GetAllTransactionResponse getAllTXNByMemberId(Long userId);
    GetAllTransactionResponse getAllTXNByInviteId(Long inviteId);
    GetAllTransactionResponse getAllTxnByTxnId(Long txnID);
    TransactionDetailsResponse getTXNByTXNDetailsID(Long txnDetailsID);
    GetAllTransactionDetailsSpaceAndMemberResponse getAllTXNBySpaceAndMemberID(Long spaceId, Long userId);
    TransactionDetailsResponse updateTXNDetailsById(Long txnDetailsID,TransactionDetailsDTO transactionDetailsDTO);
    Boolean deleteTXNDetailsById(Long txnDetailsID);
    TransactionDetailsBalanceResponse getTxnDetailsBalance(Long userId);
}
