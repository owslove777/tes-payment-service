package com.skcc.tes.payment.domain.data;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDto {
    Long contractId;		// 관리번호
    Long amount;
}
