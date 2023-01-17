package com.cvc.agendador.controller;

import com.cvc.agendador.model.Account;
import com.cvc.agendador.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping()
    public Account saveAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "accountId") Long accountId) {
        Optional<Account> accountOpt = accountService.getAccountById(accountId);
        return accountOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }
}
