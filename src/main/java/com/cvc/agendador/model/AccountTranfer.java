package com.cvc.agendador.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountTranfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Long accountNumberSource;
    private Long accountNumberTarget;
    private BigDecimal transferAmount;
    private LocalDateTime transferSchedule;
    private Long taxa;

    @OneToOne
    @JoinColumn(name = "rate_id")
    private Rate rate;

}
