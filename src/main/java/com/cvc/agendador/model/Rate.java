package com.cvc.agendador.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rateId;
    private Long rateCode;
    private String rateDescription;
    private Long rateAmountDays;
    private Long rateValue;
}
