package com.example.splityourbills.service.implementation;

import com.example.splityourbills.dto.space.SpaceDTO;
import com.example.splityourbills.dto.spacemember.SpaceMembersDTO;
import com.example.splityourbills.dto.transaction.TransactionDTO;
import com.example.splityourbills.entity.Space;
import com.example.splityourbills.entity.Transaction;
import com.example.splityourbills.exception.custom_exceptions.common.ResourceNotFoundException;
import com.example.splityourbills.repository.SpaceRepository;
import com.example.splityourbills.repository.TransactionRepository;
import com.example.splityourbills.repository.UserRepository;
import com.example.splityourbills.response.space.SpaceResponse;
import com.example.splityourbills.response.transaction.TransactionResponse;
import com.example.splityourbills.service.interfaces.SpaceService;
import com.example.splityourbills.service.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionResponse addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = getTransactionFromDTO(transactionDTO);
        transactionRepository.save(transaction);
        long transactionId = transaction.getTransactionId();
        return createTransactionResponse(transactionId,transaction);
    }

    private Transaction getTransactionFromDTO(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction(transactionDTO);
        return transaction;
    }
    private TransactionResponse createTransactionResponse(
            Long transactionId, Transaction transaction
    ){
        TransactionResponse transactionResponse = new TransactionResponse(
                transactionId,
                transaction.getSpaceId(),
                transaction.getTransactionName(),
                transaction.getTransactionDescription(),
                transaction.getLastUpdated()

        );
        return transactionResponse;
    }
}


