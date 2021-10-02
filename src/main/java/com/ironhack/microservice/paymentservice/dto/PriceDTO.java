package com.ironhack.microservice.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {
    private Long orderId;
    private BigDecimal orderPrice;
    private String paymentId;
}
