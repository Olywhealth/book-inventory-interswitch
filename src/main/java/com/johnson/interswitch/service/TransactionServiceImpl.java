package com.johnson.interswitch.service;


import com.johnson.interswitch.model.TransactionHistory;
import com.johnson.interswitch.model.User;
import com.johnson.interswitch.repository.TransactionHistoryRepository;
import com.johnson.interswitch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService{

  private final TransactionHistoryRepository repository;
  private final UserRepository userRepository;

  @Override
  public List<TransactionHistory> getUserTransactionhistory(Long  userId) {
    log.info("Getting User transaction history");
    Optional<User> existingUser = userRepository.findById(userId);
    List<TransactionHistory> transaction = repository.findByUser(existingUser.get());
    return transaction;
  }

}
