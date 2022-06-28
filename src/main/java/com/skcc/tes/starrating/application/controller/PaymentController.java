package com.skcc.tes.starrating.application.controller;

import com.skcc.tes.starrating.domain.data.PaymentDto;
import com.skcc.tes.starrating.domain.ports.api.PaymentServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentController {

//    private final StarRateRepository repository;
    private final PaymentServicePort paymentServicePort;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World! This is Payment Service";
    }

    // Create
    @PostMapping("/payment")
    public PaymentDto paymentApproved(@RequestBody PaymentDto src) {
        return paymentServicePort.performPayment(src);
    }
}
