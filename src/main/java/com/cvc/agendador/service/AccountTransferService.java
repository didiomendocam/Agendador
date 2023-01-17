package com.cvc.agendador.service;

import com.cvc.agendador.model.AccountTranfer;
import com.cvc.agendador.model.Rate;
import com.cvc.agendador.repository.AccountTransferRepository;
import com.cvc.agendador.repository.RateRepository;
import com.cvc.agendador.utils.Calcule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class AccountTransferService {

    @Autowired
    AccountTransferRepository accountTransferRepository;

    @Autowired
    RateRepository rateRepository;

    public List<AccountTranfer> accountTransfer(@RequestBody AccountTranfer accountTranferSource, AccountTranfer accountTranferTarget) {
        List<AccountTranfer> accountTranfers = null;

        Long days = Calcule.amountDays(accountTranferSource.getTransferSchedule());
        Optional<Rate> rate = rateRepository.findById(1L);
        Long returnValue = Calcule.executeCalcTransfer(accountTranferSource, days, rate.get().getRateAmountDays(), rate.get().getRateValuePercent());

        accountTransferRepository.save(accountTranferSource);
        accountTransferRepository.save(accountTranferTarget);

        accountTranfers.add(accountTranferSource);
        accountTranfers.add(accountTranferTarget);

        return accountTranfers;
    }

    public Optional<AccountTranfer> getAccountTranferById(Long accountTransferID) {
        return accountTransferRepository.findById(accountTransferID);
    }

    public List<AccountTranfer> getAccountTransfers() {
        return accountTransferRepository.findAll();
    }
}
