package com.example.splityourbills.controller;

import com.example.splityourbills.common.BaseApiResponse;
import com.example.splityourbills.dto.transaction.TransactionDTO;
import com.example.splityourbills.exception.custom_exceptions.common.InternalServerException;
import com.example.splityourbills.dto.auth.ApiResponse;
import com.example.splityourbills.response.transaction.TransactionResponse;
import com.example.splityourbills.service.implementation.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @PostMapping("/add")
    public BaseApiResponse addTransaction(@RequestBody TransactionDTO transactionDTO){

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
