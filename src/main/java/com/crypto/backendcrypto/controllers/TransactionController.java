package com.crypto.backendcrypto.controllers;

import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.entitys.Transaction;
import com.crypto.backendcrypto.service.PortfolioService;
import com.crypto.backendcrypto.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class TransactionController {
    TransactionService transactionService;
    PortfolioService portfolioService;
    public TransactionController(TransactionService transactionService, PortfolioService portfolioService) {
        this.transactionService = transactionService;
        this.portfolioService = portfolioService;
    }

    @ResponseBody
    @GetMapping("/transaction/{id}")
    public ResponseEntity<?> getOnTransaction(@PathVariable Long id) {
        return getResponseEntity(transactionService.findTransaction(id));
    }

    @ResponseBody
    @GetMapping("/transactions/{id}")
    public ResponseEntity<?> getTransactionsPortfolio(@PathVariable Long id) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if (portfolioService.findPortfolioById(id) != null) {
            map.put("status", 1);
            map.put("data", transactionService.findTransactionByPortfolioId(id));
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Portfolio Dose not exist");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }


    @ResponseBody
    @PostMapping("/transaction/create")
    public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        transaction.setDate(formattedDate);
        return getResponseEntity(transactionService.saveTransaction(transaction));
    }

    @ResponseBody
    @PostMapping("/transaction/update")
    public ResponseEntity<?> updateTransaction(@RequestBody Transaction transaction) {
        return getResponseEntity(transactionService.saveTransaction(transaction));
    }

    @ResponseBody
    @GetMapping("/transaction/delete/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
        return getResponseEntity(transactionService.deleteTransaction(id));
    }
    private ResponseEntity<?> getResponseEntity(Transaction transaction) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if (transaction != null) {
            map.put("status", 1);
            map.put("data", transaction);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Error");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
}
