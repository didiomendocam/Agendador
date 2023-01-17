package com.cvc.agendador.repository;

import com.cvc.agendador.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
