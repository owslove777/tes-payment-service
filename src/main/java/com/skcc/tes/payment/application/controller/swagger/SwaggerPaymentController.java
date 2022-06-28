package com.skcc.tes.payment.application.controller.swagger;

import com.skcc.tes.payment.application.controller.PaymentController;
import com.skcc.tes.payment.domain.ports.api.PaymentServicePort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class SwaggerPaymentController extends PaymentController {
    public SwaggerPaymentController(PaymentServicePort paymentService) {
        super(paymentService);
    }
}
