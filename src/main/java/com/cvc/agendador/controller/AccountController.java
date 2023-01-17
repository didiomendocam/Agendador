package com.cvc.agendador.controller;

import com.cvc.agendador.model.Account;
import com.cvc.agendador.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="Account endpoint")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Operation(summary="Save Account")
    @PostMapping()
    public Account saveAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @Operation(summary="Find a specific Account by your Id")
    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "accountId") Long accountId) {
        Optional<Account> accountOpt = accountService.getAccountById(accountId);
        return accountOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary="List all Account")
    @GetMapping("/list")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }
}
