package com.example.splityourbills.service.interfaces;

import com.example.splityourbills.dto.transaction.TransactionDTO;
import com.example.splityourbills.response.transaction.TransactionResponse;

public interface TransactionService {
    TransactionResponse addTransaction(TransactionDTO transactionDTO);
}
