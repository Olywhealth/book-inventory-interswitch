package com.johnson.interswitch.service;


import com.johnson.interswitch.exception.CustomException;
import com.johnson.interswitch.model.TransactionHistory;
import com.johnson.interswitch.repository.TransactionHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService{

  private final TransactionHistoryRepository repository;

  @Override
  public TransactionHistory getUserTransactionhistory(Long id) {
    log.info("Getting User transaction history");
    Optional<TransactionHistory> transaction = repository.findById(id);
    return transaction.orElseThrow( ()-> new CustomException("No transaction with ID: "+id));
  }

}
