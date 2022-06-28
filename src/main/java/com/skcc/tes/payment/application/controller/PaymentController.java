package com.skcc.tes.payment.application.controller;

import com.skcc.tes.payment.domain.data.PaymentDto;
import com.skcc.tes.payment.domain.ports.api.PaymentServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS})
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
