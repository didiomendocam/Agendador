package com.cvc.agendador.service;

import com.cvc.agendador.model.Rate;
import com.cvc.agendador.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class RateService {

    @Autowired
    RateRepository rateRepository;

    public Rate saveRate(@RequestBody Rate rate) {
        return rateRepository.save(rate);
    }

    public Optional<Rate> getRateById(Long rateID) {
        return rateRepository.findById(rateID);
    }

    public List<Rate> getRates() {
        return rateRepository.findAll();
    }
}
