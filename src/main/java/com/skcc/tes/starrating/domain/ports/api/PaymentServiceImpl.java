package com.skcc.tes.starrating.domain.ports.api;

import com.skcc.tes.starrating.domain.data.PaymentDto;
import com.skcc.tes.starrating.infrastructure.adapters.kafka.PaymentApproved;

import javax.transaction.Transactional;

public class PaymentServiceImpl implements PaymentServicePort {

    @Override
    @Transactional
    public PaymentDto performPayment(PaymentDto src) {
        PaymentApproved paymentApproved = PaymentApproved.builder()
                .contractId(src.getContractId())
                .amount(src.getAmount())
                .build();
        paymentApproved.publishAfterCommit();
        return src;
    }
}
