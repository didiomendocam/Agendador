package com.cvc.agendador.controller;

import com.cvc.agendador.model.AccountTranfer;
import com.cvc.agendador.service.AccountTransferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="Account Transfer endpoint")
@RestController
@RequestMapping("/transfer")
public class AccountTransferController {

    @Autowired
    AccountTransferService accountTransferService;

    @Operation(summary="Save Account Transfer")
    @PostMapping()
    public AccountTranfer accountTransfer(@RequestBody AccountTranfer accountTranfer) {
        return accountTransferService.accountTransfer(accountTranfer);
    }

    @Operation(summary="Find Account Transfer by you id")
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountTranfer> getAccountById(@PathVariable(value = "accountTransferId") Long accountTransferId) {
        Optional<AccountTranfer> accountTransferOpt = accountTransferService.getAccountTranferById(accountTransferId);
        return accountTransferOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary="List all Account Transfer")
    @GetMapping("/list")
    public List<AccountTranfer> getAccounts() {
        return accountTransferService.getAccountTransfers();
    }
}
