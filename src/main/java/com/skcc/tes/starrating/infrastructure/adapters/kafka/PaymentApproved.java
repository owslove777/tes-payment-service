package com.skcc.tes.starrating.infrastructure.adapters.kafka;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentApproved extends AbstractKafkaEventAdapter {
    private Long amount;
    private Long contractId;
}
