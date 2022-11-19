package com.example.splityourbills.controller;

import com.example.splityourbills.common.BaseApiResponse;
import com.example.splityourbills.dto.auth.ApiResponse;
import com.example.splityourbills.dto.transaction.TransactionDTO;
import com.example.splityourbills.dto.transactiondetails.TransactionDetailsDTO;
import com.example.splityourbills.exception.custom_exceptions.common.InternalServerException;
import com.example.splityourbills.response.transaction.TransactionResponse;
import com.example.splityourbills.response.transactionDetails.*;
import com.example.splityourbills.service.implementation.TransactionDetailsServiceImpl;
import com.example.splityourbills.service.implementation.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/transaction/details")
public class TransactionDetailsController {

    @Autowired
    private TransactionDetailsServiceImpl transactionDetailsService;

    @PostMapping("/add")
    public BaseApiResponse addTransactionDetails(@RequestBody List<TransactionDetailsDTO> transactionDTO){

        AddTransactionDetailResponse response = transactionDetailsService.addNewTransactionDetail(transactionDTO);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new InternalServerException("Unexpected error occured");
        }
    }

    @GetMapping()
    public BaseApiResponse getAllTXNBySpaceId(@RequestParam Long spaceId){

        GetAllTransactionDetailsSpaceAndMemberResponse response =  transactionDetailsService.getAllTXNResponseBySpaceId(spaceId);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new InternalServerException("Unexpected error occured");
        }
    }

    @GetMapping("/user")
    public BaseApiResponse getAllTXNByUserId(@RequestParam Long userId){
        GetAllTransactionResponse response =  transactionDetailsService.getAllTXNByMemberId(userId);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new InternalServerException("Unexpected error occured");
        }
    }

    //TODO test this
    @GetMapping("/invites")
    public BaseApiResponse getAllTXNByInviteId(@RequestParam Long userInviteId){
        GetAllTransactionResponse response =  transactionDetailsService.getAllTXNByInviteId(userInviteId);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new InternalServerException("Unexpected error occured");
        }
    }

    @GetMapping("/single/txn")
    public BaseApiResponse getAllTXNDetailsByTXNId(@RequestParam Long txnId){
        GetAllTransactionResponse response =  transactionDetailsService.getAllTxnByTxnId(txnId);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new InternalServerException("Unexpected error occured");
        }
    }

    @GetMapping("/single/details")
    public BaseApiResponse getTXNDetailsByTXNDetailsId(@RequestParam Long txnDetailsId){
        TransactionDetailsResponse response =  transactionDetailsService.getTXNByTXNDetailsID(txnDetailsId);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new InternalServerException("Unexpected error occured");
        }

    }

    @GetMapping("/all")
    public BaseApiResponse getAllTXNBySpaceAndMemberID(@RequestParam Long spaceId,
                                                       @RequestParam Long userId){
        GetAllTransactionDetailsSpaceAndMemberResponse response =  transactionDetailsService.getAllTXNBySpaceAndMemberID(spaceId,userId);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new InternalServerException("Unexpected error occured");
        }

    }

    @GetMapping("/balance")
    public BaseApiResponse getTxnBalance(@RequestParam Long userId) {
        TransactionDetailsBalanceResponse response =  transactionDetailsService.getTxnDetailsBalance(userId);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new InternalServerException("Unexpected error occured");
        }
    }

    @PutMapping()
    public BaseApiResponse updateTXNDetailsById(@RequestParam Long txnDetailsId,
                                                @RequestBody TransactionDetailsDTO transactionDetailsDTO) {

        TransactionDetailsResponse response =
                transactionDetailsService.updateTXNDetailsById(txnDetailsId, transactionDetailsDTO);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new InternalServerException("Unexpected error occured");
        }

    }

    @DeleteMapping()
    public ResponseEntity<?> deleteTXNDetailsById(@RequestParam Long txnDetailsId){
        Boolean response = transactionDetailsService.deleteTXNDetailsById(txnDetailsId);
        if (response){
            return new ResponseEntity<ApiResponse>(new
                    ApiResponse(true,"Successfully deleted", HttpStatus.OK),HttpStatus.OK);
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
