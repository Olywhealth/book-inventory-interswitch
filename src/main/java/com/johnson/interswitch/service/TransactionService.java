package com.johnson.interswitch.service;


import com.johnson.interswitch.model.TransactionHistory;

public interface TransactionService {
    TransactionHistory getUserTransactionhistory(Long id);
}
