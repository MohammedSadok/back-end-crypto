package com.crypto.backendcrypto.service;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.entitys.Portfolio;

import java.util.List;

public interface AccountService {
    public Account saveAccount (Account account);
    public List<Account> findAllAccounts ();
    public Account findAccountById(Long id);
    public Account deleteAccount(Account account);
    public Account updateAccount (Account account);
    public List<Portfolio> findAccountPortfolios (Account account);
}
