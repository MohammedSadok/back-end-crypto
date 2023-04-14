package com.crypto.backendcrypto.web;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @GetMapping ("/accounts")
    public List<Account> accountList(){
        return accountRepository.findAll();
    }
}
