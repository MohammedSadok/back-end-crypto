package com.crypto.backendcrypto.repositories;

import com.crypto.backendcrypto.entitys.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    
}
