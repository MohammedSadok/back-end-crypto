package com.crypto.backendcrypto.controllers;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @PostMapping("/account/create")
    public ResponseEntity<?> saveAccount(@RequestBody Account account){
        Account account1 = accountService.saveAccount(account);
        return getResponseEntity(account1);
    }


    @ResponseBody
    @PostMapping ("/account/update")
    public ResponseEntity<?> updateAccount(@RequestBody Account account1){
        Account account = accountService.updateAccount(account1);
        return getResponseEntity(account);
    }

    private ResponseEntity<?> getResponseEntity(Account account) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(account != null) {
            map.put("status", 1);
            map.put("data", account);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else  {
            map.clear();
            map.put("status", 0);
            map.put("message", "Error");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @ResponseBody
    @GetMapping ("/account/{id}")
    public ResponseEntity<?> findAccount(@PathVariable Long id){
        Account account = accountService.findAccountById(id);
        return getResponseEntity(account);

    }
}
