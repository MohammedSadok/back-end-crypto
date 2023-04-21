package com.crypto.backendcrypto.service;

import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.entitys.Transaction;

import java.util.List;

public interface PortfolioService {
    public Portfolio savePortfolio(Portfolio portfolio);
    public Portfolio findPortfolioById(Long id);
    public Portfolio deletePortfolio (Long id);
    public Portfolio updatePortfolio (Portfolio portfolio);
    public List<Portfolio> findAccountPortfolios (Long id);
}
