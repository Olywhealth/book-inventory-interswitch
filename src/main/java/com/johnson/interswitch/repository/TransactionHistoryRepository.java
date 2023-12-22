package com.johnson.interswitch.repository;

import com.johnson.interswitch.model.TransactionHistory;
import com.johnson.interswitch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Johnson on 17/12/2023
 */
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {

    List<TransactionHistory> findByUser(User user);
}
