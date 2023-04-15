package com.crypto.backendcrypto.service;

import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.entitys.Transaction;
import com.crypto.backendcrypto.repositories.PortfolioRepository;
import com.crypto.backendcrypto.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PortfolioServiceImp implements PortfolioService{
    PortfolioRepository portfolioRepository;
    public PortfolioServiceImp(PortfolioRepository portfolioRepository, TransactionRepository transactionRepository) {
        this.portfolioRepository = portfolioRepository;
    }


    @Override
    public Portfolio savePortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public Portfolio findPortfolioById(Long id) {
        return portfolioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Portfolio> findAllPortfolios() {
        return portfolioRepository.findAll();
    }

    @Override
    public Portfolio deletePortfolio(Portfolio portfolio) {
        portfolioRepository.delete(portfolio);
        return portfolio;
    }

    @Override
    public Portfolio updatePortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public List<Transaction> findPortfolioTransactions(Long id) {
        return portfolioRepository.findPortfolioTransactions(id);
    }
}