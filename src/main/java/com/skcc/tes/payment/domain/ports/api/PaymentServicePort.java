package com.skcc.tes.payment.domain.ports.api;

import com.skcc.tes.payment.domain.data.PaymentDto;

public interface PaymentServicePort {
    PaymentDto performPayment(PaymentDto src);
}
