package com.example.splityourbills.service.interfaces;

import com.example.splityourbills.dto.transaction.TransactionDTO;
import com.example.splityourbills.response.transaction.TransactionResponse;
import com.example.splityourbills.response.transactionDetails.TransactionDetailsResponse;

public interface TransactionService {
    TransactionResponse addTransaction(TransactionDTO transactionDTO);
    Boolean deleteTransaction(Long transactionId);
}
