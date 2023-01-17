package com.cvc.agendador.repository;

import com.cvc.agendador.model.AccountTranfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTransferRepository extends JpaRepository<AccountTranfer, Long> {

}
