package com.crypto.backendcrypto.controllers;


import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.service.AccountService;
import com.crypto.backendcrypto.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PortfolioController {
    private PortfolioService portfolioService;
    private AccountService accountService;
    public PortfolioController(PortfolioService portfolioService,AccountService accountService) {
        this.portfolioService = portfolioService;
        this.accountService = accountService;
    }

    @ResponseBody
    @GetMapping("/portfolio/get/{id}")
    public Portfolio getOnePortFolio(@PathVariable Long id) {
        return portfolioService.findPortfolioById(id);
    }

    @ResponseBody
    @PostMapping("/portfolio/create")
    Portfolio savePortfolio(@RequestBody Portfolio portfolio) {
       Account account = accountService.findAccountById(portfolio.getAccount().getId());
       Portfolio newPortfolio = new Portfolio(null,portfolio.getNom(),account,null);
       return portfolioService.savePortfolio(newPortfolio);
    }

    @ResponseBody
    @PostMapping("/portfolio/update")
    Portfolio updatePortfolio(@RequestBody Portfolio portfolio) {
        System.out.println(portfolio);
        return null;
/*        Account account = accountService.findAccountById(portfolio.getAccount().getId());
        Portfolio newPortfolio = new Portfolio(portfolio.getId(),portfolio.getNom(),account,portfolio.getTransactions());
        return portfolioService.savePortfolio(newPortfolio);*/
    }

    @ResponseBody
    @PostMapping("/portfolio/delete")
    Portfolio deletePortfolio(@RequestBody Long id) {
        return portfolioService.deletePortfolio(id);
    }

}
