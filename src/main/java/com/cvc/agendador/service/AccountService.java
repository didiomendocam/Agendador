package com.cvc.agendador.service;

import com.cvc.agendador.model.Account;
import com.cvc.agendador.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account saveAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccountById(Long accountID) {
        return accountRepository.findById(accountID);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
