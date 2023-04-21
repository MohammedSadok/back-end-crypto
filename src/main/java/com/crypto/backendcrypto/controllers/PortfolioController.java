package com.crypto.backendcrypto.controllers;


import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.service.AccountService;
import com.crypto.backendcrypto.service.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class PortfolioController {
    private PortfolioService portfolioService;
    private AccountService accountService;

    public PortfolioController(PortfolioService portfolioService, AccountService accountService) {
        this.portfolioService = portfolioService;
        this.accountService = accountService;
    }

    @ResponseBody
    @GetMapping("/portfolios/{id}")
    public ResponseEntity<?> getAllPortFolios(@PathVariable Long id) {

        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if (accountService.findAccountById(id) != null) {
            map.put("status", 1);
            map.put("data", portfolioService.findAccountPortfolios(id));
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Account Dose not exist");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @ResponseBody
    @GetMapping("/portfolio/{id}")
    public ResponseEntity<?> getOnePortFolio(@PathVariable Long id) {
        return getResponseEntity(portfolioService.findPortfolioById(id));
    }

    @ResponseBody
    @PostMapping("/portfolio/create")
    public ResponseEntity<?> savePortfolio(@RequestBody Portfolio portfolio) {
        return getResponseEntity(portfolioService.savePortfolio(portfolio));
    }

    @ResponseBody
    @PostMapping("/portfolio/update")
    public ResponseEntity<?> updatePortfolio(@RequestBody Portfolio portfolio) {
        return getResponseEntity(portfolioService.updatePortfolio(portfolio));
    }

    @ResponseBody
    @GetMapping("/portfolio/delete/{id}")
    public ResponseEntity<?> deletePortfolio(@PathVariable Long id) {
        Portfolio portfolio = portfolioService.deletePortfolio(id);
        return getResponseEntity(portfolio);
    }

    private ResponseEntity<?> getResponseEntity(Portfolio portfolio) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if (portfolio != null) {
            map.put("status", 1);
            map.put("data", portfolio);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Error");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
}
