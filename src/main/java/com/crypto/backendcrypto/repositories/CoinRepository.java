package com.crypto.backendcrypto.repositories;

import com.crypto.backendcrypto.entitys.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, Long> {

}
