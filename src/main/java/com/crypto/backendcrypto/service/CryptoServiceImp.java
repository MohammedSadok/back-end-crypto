package com.crypto.backendcrypto.service;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.entitys.Coin;
import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.entitys.Transaction;
import com.crypto.backendcrypto.repositories.AccountRepository;
import com.crypto.backendcrypto.repositories.CoinRepository;
import com.crypto.backendcrypto.repositories.PortfolioRepository;
import com.crypto.backendcrypto.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CryptoServiceImp implements CryptoService {

    private CoinRepository coinRepository;
    private TransactionRepository transactionRepository;
    private PortfolioRepository portfolioRepository;
    private AccountRepository accountRepository;

    public CryptoServiceImp(CoinRepository coinRepository, TransactionRepository transactionRepository, PortfolioRepository portfolioRepository, AccountRepository accountRepository) {
        this.coinRepository = coinRepository;
        this.transactionRepository = transactionRepository;
        this.portfolioRepository = portfolioRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Coin saveCoin(Coin coin) {
        return coinRepository.save(coin);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Portfolio savePortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
}
