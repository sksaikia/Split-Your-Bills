package com.example.splityourbills.controller;

import com.example.splityourbills.common.BaseApiResponse;
import com.example.splityourbills.dto.spacemember.NewSpaceMemberDTO;
import com.example.splityourbills.dto.transaction.TransactionDTO;
import com.example.splityourbills.exception.custom_exceptions.common.InternalServerException;
import com.example.splityourbills.exception.custom_exceptions.common.ResourceNotFoundException;
import com.example.splityourbills.model.auth.ApiResponse;
import com.example.splityourbills.response.spaceMember.AddMemberToSpaceResponse;
import com.example.splityourbills.response.spaceMember.GetAllSpaceMembersResponse;
import com.example.splityourbills.response.spaceMember.SpaceMemberResponse;
import com.example.splityourbills.service.implementation.SpaceMemberServiceImpl;
import com.example.splityourbills.service.implementation.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addTransaction(@RequestBody TransactionDTO transactionDTO){

       Boolean success = transactionService.addTransaction(transactionDTO);
        if (success){
            return new ResponseEntity<ApiResponse>(new ApiResponse(true,
                    "Succesfully transaction added"), HttpStatus.OK);
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
