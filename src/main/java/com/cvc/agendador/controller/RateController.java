package com.cvc.agendador.controller;


import com.cvc.agendador.model.Rate;
import com.cvc.agendador.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/rate")
public class RateController {

    @Autowired
    RateService rateService;

    @PostMapping()
    public Rate saveRate(@RequestBody Rate rate) {
        return rateService.saveRate(rate);
    }

    @GetMapping("/{rateId}")
    public ResponseEntity<Rate> getRateById(@PathVariable(value = "rateId") Long rateId) {
        Optional<Rate> rateOpt = rateService.getRateById(rateId);
        return rateOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public List<Rate> getRates() {
        return rateService.getRates();
    }

}
