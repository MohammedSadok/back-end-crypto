package com.crypto.backendcrypto.service;

import com.crypto.backendcrypto.entitys.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction saveTransaction (Transaction transaction);
    public Transaction updateTransaction (Transaction transaction);
    public Transaction deleteTransaction(Long id);
    public Transaction findTransaction (Long id);
    public List <Transaction> findTransactionByPortfolioId (Long id);
}
