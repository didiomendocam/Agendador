package com.cvc.agendador.service;

import com.cvc.agendador.model.AccountTranfer;
import com.cvc.agendador.model.Rate;
import com.cvc.agendador.repository.AccountTransferRepository;
import com.cvc.agendador.repository.RateRepository;
import com.cvc.agendador.utils.Calcule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AccountTransferService {

    @Autowired
    AccountTransferRepository accountTransferRepository;

    @Autowired
    RateRepository rateRepository;

    public AccountTranfer accountTransfer(@RequestBody AccountTranfer accountTranfer) {
        List<AccountTranfer> accountTranfers = null;

        Long days = Calcule.amountDays(accountTranfer.getTransferSchedule());
        Optional<Rate> rate = Optional.ofNullable(rateRepository.findByRangeRateDays(days.longValue()));
        Long returnValue = Calcule.executeCalcTransfer(accountTranfer, days, rate.get().getRateAmountDays(), rate.get().getRateValuePercent());

        accountTranfer.setTaxa(returnValue);
        accountTransferRepository.save(accountTranfer);

        return accountTranfer;
    }

    public Optional<AccountTranfer> getAccountTranferById(Long accountTransferID) {
        return accountTransferRepository.findById(accountTransferID);
    }

    public List<AccountTranfer> getAccountTransfers() {
        return accountTransferRepository.findAll();
    }
}
