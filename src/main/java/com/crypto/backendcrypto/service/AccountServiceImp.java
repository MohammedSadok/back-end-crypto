package com.crypto.backendcrypto.service;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.repositories.AccountRepository;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class AccountServiceImp implements AccountService, UserDetailsService {
    AccountRepository accountRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account saveAccount(Account account) {
        if (accountRepository.findAccountByEmail(account.getEmail()).orElse(null) != null)
            return null;
        account.setMotDePasse(passwordEncoder.encode(account.getMotDePasse()));
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account deleteAccount(Account account) {
        if (accountRepository.existsById(account.getId())) {
            accountRepository.delete(account);
            return account;
        } else {
            return null;
        }
    }

    @Override
    public Account updateAccount(Account account) {
        if (accountRepository.existsById(account.getId())) {
            account.setMotDePasse(passwordEncoder.encode(account.getMotDePasse()));
            accountRepository.update(account.getId(), account.getNom(), account.getPrenom(), account.getEmail(), account.getTelephone(), account.getMotDePasse());
            return account;
        } else {
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findAccountByEmail(email);
        if(account == null){
            throw new UsernameNotFoundException("User not found in the database");
        }else{
            //log.info("User found in the database: {}", email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(account.get().getEmail(), account.get().getMotDePasse(),authorities);
    }

    @Override
    public Optional<Account> findAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }
}
