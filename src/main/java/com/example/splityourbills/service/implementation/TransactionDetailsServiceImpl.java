package com.example.splityourbills.service.implementation;

import com.example.splityourbills.common.Constants;
import com.example.splityourbills.dto.transaction.TransactionDTO;
import com.example.splityourbills.dto.transactiondetails.TransactionDetailsDTO;
import com.example.splityourbills.entity.Space;
import com.example.splityourbills.entity.Transaction;
import com.example.splityourbills.entity.TransactionDetails;
import com.example.splityourbills.exception.custom_exceptions.common.ResourceNotFoundException;
import com.example.splityourbills.repository.TransactionDetailsRepository;
import com.example.splityourbills.repository.TransactionRepository;
import com.example.splityourbills.response.transaction.TransactionResponse;
import com.example.splityourbills.response.transactionDetails.*;
import com.example.splityourbills.service.interfaces.TransactionDetailsService;
import com.example.splityourbills.service.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.example.splityourbills.common.Constants.ADDED_TRANSACTION_DETAIL;

@Service
@Transactional
public class TransactionDetailsServiceImpl implements TransactionDetailsService {

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;


    private Integer addTransaction(TransactionDetailsDTO transactionDTO){
        TransactionDetails transaction = getTransactionDetailsFromDTO(transactionDTO);
        transactionDetailsRepository.save(transaction);
        return Constants.ADDED_TRANSACTION_DETAIL;
    }

    /**
     * Add a list of txn detail
     * */
    @Override
    public AddTransactionDetailResponse addNewTransactionDetail(List<TransactionDetailsDTO> transactionDetailsDTOs) {
        int success = 0,failure =0, ignored = 0;
        for (TransactionDetailsDTO transactionDetailsDTO : transactionDetailsDTOs) {
            int status = addTransaction(transactionDetailsDTO);
            if (status== ADDED_TRANSACTION_DETAIL){
                success++;
            }else {
                failure++;
            }
        }
        return new AddTransactionDetailResponse(success,failure,ignored);
    }

    /**
     * Get all transaction details by space ID
     * */
    //TODO need to add pagination
    @Override
    public GetAllTransactionDetailsSpaceAndMemberResponse getAllTXNResponseBySpaceId(Long spaceId) {
        Optional<List<TransactionDetailsSpaceAndMemberResponse>> optionalResponses =
                transactionDetailsRepository.findBySpaceId(spaceId);
        if(optionalResponses.isPresent()){
            List<TransactionDetailsSpaceAndMemberResponse> responses = optionalResponses.get();
            GetAllTransactionDetailsSpaceAndMemberResponse response =
                    new GetAllTransactionDetailsSpaceAndMemberResponse(responses.size(),responses);
            return response;
        }else{
            throw new ResourceNotFoundException("Details with TXn details id not found, space id : " + spaceId);
        }
    }

    /**
     * Get all transaction Details by a member id
     * */
    @Override
    public GetAllTransactionResponse getAllTXNByMemberId(Long userId) {
        Optional<List<TransactionDetails>> optionalTXNDetails = transactionDetailsRepository
                .findByPersonId(userId, Sort.by(Sort.Direction.DESC, "lastUpdated"));
        if (optionalTXNDetails.isPresent()){
            List<TransactionDetails> txnDetails = optionalTXNDetails.get();
            List<TransactionDetailsResponse> transactionDetailsResponses = new ArrayList<>();
            for(TransactionDetails transactionDetails : txnDetails){
                TransactionDetailsResponse txnDetailsResponse = new TransactionDetailsResponse(transactionDetails);
                transactionDetailsResponses.add(txnDetailsResponse);
            }
            return new GetAllTransactionResponse(transactionDetailsResponses.size(),transactionDetailsResponses);

        }else{
            throw new ResourceNotFoundException("TXN with the particular user id is not present, userID : " + userId);
        }
    }

    /**
     * Get all transaction Details by a invite id
     * */
    @Override
    public GetAllTransactionResponse getAllTXNByInviteId(Long inviteId) {
        Optional<List<TransactionDetails>> optionalTXNDetails = transactionDetailsRepository
                .findByInviteId(inviteId);
        if (optionalTXNDetails.isPresent()){
            List<TransactionDetails> txnDetails = optionalTXNDetails.get();
            List<TransactionDetailsResponse> transactionDetailsResponses = new ArrayList<>();
            for(TransactionDetails transactionDetails : txnDetails){
                TransactionDetailsResponse txnDetailsResponse = new TransactionDetailsResponse(transactionDetails);
                transactionDetailsResponses.add(txnDetailsResponse);
            }
            return new GetAllTransactionResponse(transactionDetailsResponses.size(),transactionDetailsResponses);

        }else{
            throw new ResourceNotFoundException("TXN with the particular invite id is not present, inviteId : " + inviteId);
        }
    }

    /**
     * Get all the transaction details for a particular transaction id
     * */
    @Override
    public GetAllTransactionResponse getAllTxnByTxnId(Long txnID) {
        Optional<List<TransactionDetails>> optionalTxnDetails = transactionDetailsRepository.findByTransactionID(txnID);
        List<TransactionDetailsResponse> txnDetailsResponses = new ArrayList<>();
        if (optionalTxnDetails.isPresent()){
            List<TransactionDetails> txnDetails = optionalTxnDetails.get();
            for (TransactionDetails transactionDetails : txnDetails){
                TransactionDetailsResponse transactionDetailsResponse = new TransactionDetailsResponse(transactionDetails);
                txnDetailsResponses.add(transactionDetailsResponse);
            }
            return new GetAllTransactionResponse(txnDetailsResponses.size(),txnDetailsResponses);

        }else{
            throw new ResourceNotFoundException("TXN Details with TXN id not found, " + txnID);
        }
    }

    /**
     * Get a single TXN Details by TXN id
     * */
    @Override
    public TransactionDetailsResponse getTXNByTXNDetailsID(Long txnDetailsID) {
        Optional<TransactionDetails> optionalTxn = transactionDetailsRepository.findByTransactionDetailsId(txnDetailsID);
        if (optionalTxn.isPresent()){
            TransactionDetails transactionDetails = optionalTxn.get();
            TransactionDetailsResponse transactionResponse = new TransactionDetailsResponse(transactionDetails);
            return transactionResponse;

        }else{
            throw new ResourceNotFoundException("Details with TXn details id not found, txn details id : " + txnDetailsID);
        }
    }

    /**
     * Get a list of TXN Details Response by particular space and member id
     * */
    @Override
    public GetAllTransactionDetailsSpaceAndMemberResponse getAllTXNBySpaceAndMemberID(Long spaceId, Long userId) {

        Optional<List<TransactionDetailsSpaceAndMemberResponse>> optionalResponses =
                transactionDetailsRepository.findBYSpaceIdAndPersonId(spaceId, userId);
        if(optionalResponses.isPresent()){
            List<TransactionDetailsSpaceAndMemberResponse> responses = optionalResponses.get();
            GetAllTransactionDetailsSpaceAndMemberResponse response =
                    new GetAllTransactionDetailsSpaceAndMemberResponse(responses.size(),responses);
            return response;
        }else{
            throw new ResourceNotFoundException("Details with TXn details id not found, space id : " + spaceId + " userId : " + userId);
        }
    }

    /**
     * Update a txn details by txn details id
     * */
    @Override
    public TransactionDetailsResponse updateTXNDetailsById(Long txnDetailsID,TransactionDetailsDTO transactionDetailsDTO) {
        Optional<TransactionDetails> optionalTransactionDetails = transactionDetailsRepository.findByTransactionDetailsId(txnDetailsID);
        if(optionalTransactionDetails.isPresent()){
            TransactionDetails transactionDetails = optionalTransactionDetails.get();
            transactionDetails.setPersonId(transactionDetailsDTO.getPersonId());
            transactionDetails.setInviteId(transactionDetailsDTO.getInviteId());
            transactionDetails.setAmount(transactionDetailsDTO.getAmount());
            transactionDetailsRepository.save(transactionDetails);
            return createTransactionDetailsResponse(txnDetailsID,transactionDetails);
        }else{
            throw new ResourceNotFoundException("TXN details with txn Details ID: " + txnDetailsID + " not found.");
        }
    }

    /**
     * Delete a single TXN details by txn details id
     * */
    @Override
    public Boolean deleteTXNDetailsById(Long txnDetailsID) {
        Optional<TransactionDetails> optionalTransactionDetails = transactionDetailsRepository
                .findByTransactionDetailsId(txnDetailsID);
        if (optionalTransactionDetails.isPresent()){
            transactionDetailsRepository.deleteById(txnDetailsID);
            return true;
        }else{
            return false;
        }
    }

    private TransactionDetails getTransactionDetailsFromDTO(TransactionDetailsDTO transactionDTO) {
        TransactionDetails transactionDetails = new TransactionDetails(transactionDTO);
        return transactionDetails;
    }
    private TransactionDetailsResponse createTransactionDetailsResponse(
            Long transactionId, TransactionDetails transactionDetails
    ){
        TransactionDetailsResponse transactionDetailsResponse = new TransactionDetailsResponse(
                transactionId,
                transactionDetails.getTransactionID(),
                transactionDetails.getPersonId(),
                transactionDetails.getInviteId(),
                transactionDetails.getAmount(),
                transactionDetails.getTransaction().getLastUpdated(),
                transactionDetails.getPayableAmount(),
                transactionDetails

        );
        return transactionDetailsResponse;
    }
}


