package com.crypto.backendcrypto.repositories;

import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.entitys.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    @Query("select t from Transaction t where t.portfolio.id = :id")
    List<Transaction> findPortfolioTransactions(@Param("id") Long id);
}
