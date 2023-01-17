package com.cvc.agendador.utils;

import com.cvc.agendador.model.AccountTranfer;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Calcule {
    public static Long executeCalcTransfer(AccountTranfer accountTranfer, Long days, Long amountDays, Long nPercent) {
        return calcTransfer(days, amountDays, nPercent, accountTranfer.getTransferAmount().longValue());
    }

    public static Long amountDays(LocalDateTime dtTransfer) {
        return dtTransfer.until(LocalDateTime.now(), ChronoUnit.DAYS);
    }

    private static Long calcTransfer(Long nDays, Long amountDays, Long nPercent, Long amountTransfer) {
        Long returnValue = 0L;

        if (nDays == 0) {
            returnValue = (amountTransfer * 3) + (amountTransfer/3);
        } else if(nDays > 40 && amountTransfer > 100.000) {
            returnValue = (amountTransfer * amountDays) + (amountTransfer/2);
        } else {
            returnValue = (amountTransfer * amountDays) + (amountTransfer/nPercent);
        }

        return returnValue;
    }
}
