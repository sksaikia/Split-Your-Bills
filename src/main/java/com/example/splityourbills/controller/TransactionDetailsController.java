package com.example.splityourbills.controller;

import com.example.splityourbills.common.BaseApiResponse;
import com.example.splityourbills.dto.transaction.TransactionDTO;
import com.example.splityourbills.exception.custom_exceptions.common.InternalServerException;
import com.example.splityourbills.response.transaction.TransactionResponse;
import com.example.splityourbills.service.implementation.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/transaction/details")
public class TransactionDetailsController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @PostMapping("/add")
    public BaseApiResponse addTransactionDetails(@RequestBody TransactionDTO transactionDTO){

        TransactionResponse response = transactionService.addTransaction(transactionDTO);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new InternalServerException("Unexpected error occured");
        }
    }

    private <DT> BaseApiResponse<DT> createBaseApiResponse(DT data){
        BaseApiResponse<DT> baseApiResponse = new BaseApiResponse<>(true);
        baseApiResponse.setData(data);
        return baseApiResponse;
    }

}
