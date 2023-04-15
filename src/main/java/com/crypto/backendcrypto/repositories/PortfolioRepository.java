package com.crypto.backendcrypto.repositories;

import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.entitys.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    @Modifying
    @Query("select t from Transaction t where t.portfolio.id = ?1")
    List<Transaction> findPortfolioTransactions(Long id);
}
