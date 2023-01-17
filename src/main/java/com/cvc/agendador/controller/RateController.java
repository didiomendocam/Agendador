package com.cvc.agendador.controller;


import com.cvc.agendador.model.Rate;
import com.cvc.agendador.service.RateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="Rate endpoint")
@RestController
@RequestMapping("/rate")
public class RateController {

    @Autowired
    RateService rateService;

    @Operation(summary="Save Rate")
    @PostMapping()
    public Rate saveRate(@RequestBody Rate rate) {
        return rateService.saveRate(rate);
    }

    @Operation(summary="find Rate by you Id")
    @GetMapping("/{rateId}")
    public ResponseEntity<Rate> getRateById(@PathVariable(value = "rateId") Long rateId) {
        Optional<Rate> rateOpt = rateService.getRateById(rateId);
        return rateOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary="List all Rate")
    @GetMapping("/list")
    public List<Rate> getRates() {
        return rateService.getRates();
    }

}
