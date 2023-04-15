package com.crypto.backendcrypto;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.service.AccountService;
import com.crypto.backendcrypto.service.PortfolioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackEndCryptoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndCryptoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountService accountService, PortfolioService portfolioService) {
        return args -> {
            Account account = accountService.saveAccount(new Account(null, "sadom", "mohammed", "mohammed.sadok@gmail.com", "0771674164", "123456",null));
            portfolioService.savePortfolio(new Portfolio(null,"portfolio1",account,null));
        };
    }
}
