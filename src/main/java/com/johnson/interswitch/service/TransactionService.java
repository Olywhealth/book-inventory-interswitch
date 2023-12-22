package com.johnson.interswitch.service;


import com.johnson.interswitch.model.TransactionHistory;

import java.util.List;

public interface TransactionService {
    List<TransactionHistory> getUserTransactionhistory(Long userId);
}
