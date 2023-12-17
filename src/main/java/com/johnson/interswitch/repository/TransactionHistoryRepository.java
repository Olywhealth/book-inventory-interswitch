package com.johnson.interswitch.repository;

import com.johnson.interswitch.model.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johnson on 17/12/2023
 */
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
}
