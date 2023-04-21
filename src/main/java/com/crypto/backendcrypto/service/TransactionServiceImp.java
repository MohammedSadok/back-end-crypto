package com.crypto.backendcrypto.service;

import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.entitys.Transaction;
import com.crypto.backendcrypto.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class TransactionServiceImp implements TransactionService{
    TransactionRepository transactionRepository;
    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction deleteTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        transactionRepository.deleteById(id);
        return transaction;
    }

    @Override
    public Transaction findTransaction(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Transaction> findTransactionByPortfolioId(Long id) {
        return transactionRepository.findTransactionByPortfolioId(id);
    }
}
