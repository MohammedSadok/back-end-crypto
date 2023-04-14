package com.crypto.backendcrypto.repositories;

import com.crypto.backendcrypto.entitys.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
}
