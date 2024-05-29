package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

// SOLID

// Single Responsibility Principle
// Open/Closed Principle
// Liskov Substitution Principle
// Interface Segregation Principle
// Dependency Inversion Principle ( wiring components )

@Component("transferService")
public class UPITransferService implements TransferService {

    private AccountRepository accountRepository;

    @Autowired
    public UPITransferService(@Qualifier("jdbcAccountRepository") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(transactionManager = "transactionManager")
    public void transfer(String sourceAccountNumber, String targetAccountNumber, double amount) {

        // logging
        // transaction management
        // authorization
        // caching
        // metrics
        // exception handling

        // implementation
        // ...
        // step-1 : load source account
        Account sourceAccount = accountRepository.loadAccount(sourceAccountNumber);
        // step-2 : load target account
        Account targetAccount = accountRepository.loadAccount(targetAccountNumber);

        // boolean isSufficientBalance = true;
        // if (!isSufficientBalance)
        // throw new RuntimeException("Insufficient balance");

        // step-3 : debit source account
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        // step-4 : credit target account
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        // step-5 : update source account
        accountRepository.updateAccount(sourceAccount);

        boolean b = true;
        if (b)
            throw new RuntimeException("Simulating runtime exception");

        // step-6 : update target account
        accountRepository.updateAccount(targetAccount);

    }

}