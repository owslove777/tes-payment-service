package com.skcc.tes.starrating.application.config;

import com.skcc.tes.starrating.domain.ports.api.PaymentServiceImpl;
import com.skcc.tes.starrating.domain.ports.api.PaymentServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    public PaymentServicePort bookService(){
        return new PaymentServiceImpl();
    }
}
