package com.crypto.backendcrypto.service;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.entitys.Coin;
import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.entitys.Transaction;

public interface CryptoService {
    public Coin saveCoin(Coin coin);
    public Transaction saveTransaction (Transaction transaction);
    public Portfolio savePortfolio (Portfolio portfolio);
    public Account saveAccount(Account account);
}
