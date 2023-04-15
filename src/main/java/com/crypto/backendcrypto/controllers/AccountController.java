package com.crypto.backendcrypto.controllers;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @ResponseBody
    @GetMapping ("/accounts")
    public List<Account> accountList(){
        return accountService.findAllAccounts();
    }
}
