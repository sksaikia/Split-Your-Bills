package com.example.splityourbills.service.interfaces;

import com.example.splityourbills.dto.transaction.TransactionDTO;
import com.example.splityourbills.model.auth.LoginRequest;
import com.example.splityourbills.model.auth.SignUpRequest;
import com.example.splityourbills.response.auth.LoginResponse;
import com.example.splityourbills.response.transaction.TransactionResponse;

import java.net.URI;

public interface TransactionService {
    Boolean addTransaction(TransactionDTO transactionDTO);
}
