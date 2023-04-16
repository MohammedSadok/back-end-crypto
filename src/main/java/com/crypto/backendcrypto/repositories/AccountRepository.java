package com.crypto.backendcrypto.repositories;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.entitys.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("select p from Portfolio p where p.account.id = :id")
    List<Portfolio> findAccountPortfolios(@Param("id")Long id);
}
