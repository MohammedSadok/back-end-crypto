package com.crypto.backendcrypto.repositories;

import com.crypto.backendcrypto.entitys.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
