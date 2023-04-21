package com.crypto.backendcrypto.repositories;

import com.crypto.backendcrypto.entitys.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findTransactionByPortfolioId(Long id);
}
