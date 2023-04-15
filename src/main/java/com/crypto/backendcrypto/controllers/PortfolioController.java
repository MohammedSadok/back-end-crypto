package com.crypto.backendcrypto.controllers;


import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PortfolioController {
    private PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @ResponseBody
    @GetMapping("/portfolio")
    public Portfolio getOnePortFolio(@RequestParam Long id) {
        return portfolioService.findPortfolioById(id);
    }

    @PostMapping("/portfolio")
    Portfolio savePortfolio(@RequestBody Portfolio portfolio) {
        return portfolioService.savePortfolio(portfolio);
    }

}
