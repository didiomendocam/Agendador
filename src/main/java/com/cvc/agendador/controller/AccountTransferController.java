package com.cvc.agendador.controller;

import com.cvc.agendador.model.AccountTranfer;
import com.cvc.agendador.service.AccountTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/transfer")
public class AccountTransferController {

    @Autowired
    AccountTransferService accountTransferService;

    @PostMapping()
    public List<AccountTranfer> accountTransfer(@RequestBody AccountTranfer accountTranferSource, AccountTranfer accountTranferTarget) {
        return accountTransferService.accountTransfer(accountTranferSource, accountTranferTarget);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountTranfer> getAccountById(@PathVariable(value = "accountTransferId") Long accountTransferId) {
        Optional<AccountTranfer> accountTransferOpt = accountTransferService.getAccountTranferById(accountTransferId);
        return accountTransferOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public List<AccountTranfer> getAccounts() {
        return accountTransferService.getAccountTransfers();
    }
}
