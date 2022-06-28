package com.skcc.tes.starrating.domain.ports.api;

import com.skcc.tes.starrating.domain.data.PaymentDto;

public interface PaymentServicePort {
    PaymentDto performPayment(PaymentDto src);
}
