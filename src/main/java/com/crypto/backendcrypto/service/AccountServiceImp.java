package com.crypto.backendcrypto.service;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class AccountServiceImp implements AccountService {
    AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account deleteAccount(Account account) {
        if (accountRepository.existsById(account.getId())) {
            accountRepository.delete(account);
            return account;
        } else {
            return null;
        }
    }

    @Override
    public Account updateAccount(Account account) {
        return null;
    }

    @Override
    public List<Portfolio> findAccountPortfolios(Long id) {
        return accountRepository.findAccountPortfolios(id);
    }
}
