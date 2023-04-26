package com.crypto.backendcrypto;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.entitys.Portfolio;
import com.crypto.backendcrypto.service.AccountService;
import com.crypto.backendcrypto.service.PortfolioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
public class BackEndCryptoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndCryptoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(AccountService accountService, PortfolioService portfolioService) {
//        return args -> {
//            Account account = accountService.saveAccount(new Account(null, "sadom", "mohammed", "mohammed.sadok@gmail.com", "0771674164", "123456",null));
//            portfolioService.savePortfolio(new Portfolio(null,"portfolio1",account,null));
//        };
//    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(AccountService accountService){
        return args -> {
          // accountService.saveAccount(new Account(null, "test", "test", "test@gmail.com", "0771674164", "admin",null));
        };
    }

    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String PUT = "PUT";
    private static final String DELETE = "DELETE";




    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods(GET, POST, PUT, DELETE)
                        .allowedHeaders("*")
                        .allowedOriginPatterns("*")
                        .allowCredentials(true);

            }
        };
    }





}
