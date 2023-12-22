package com.johnson.interswitch.controller;

import com.johnson.interswitch.model.TransactionHistory;
import com.johnson.interswitch.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;


    @ApiOperation(value = "User transaction", notes = "User transaction history", response = TransactionHistory.class, responseContainer = "List")
    @PostMapping(value = "/{userId}/transaction-history", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TransactionHistory>> getTransactionHistory(@PathVariable Long userId) {
        List<TransactionHistory> response = transactionService.getUserTransactionhistory(userId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
