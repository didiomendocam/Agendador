package com.cvc.agendador.repository;

import com.cvc.agendador.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
    @Query(
            value = "SELECT * FROM  rate WHERE rate_amount_days >= :amountDays limit 1 ",
            nativeQuery = true
    )
    Rate findByRangeRateDays(Long amountDays);
}
