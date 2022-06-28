package com.skcc.tes.payment.application.config;

import com.skcc.tes.payment.domain.ports.api.PaymentServiceImpl;
import com.skcc.tes.payment.domain.ports.api.PaymentServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    public PaymentServicePort bookService(){
        return new PaymentServiceImpl();
    }
}
