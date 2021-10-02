package com.ironhack.microservice.paymentservice.service;

import com.ironhack.microservice.paymentservice.dto.ConfirmationDTO;
import com.ironhack.microservice.paymentservice.dto.OrderDTO;
import com.ironhack.microservice.paymentservice.dto.PayDTO;
import com.ironhack.microservice.paymentservice.dto.RequestDTO;
import com.ironhack.microservice.paymentservice.proxy.OrderServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    BigDecimal cookiePrice = BigDecimal.valueOf(3);

    @Autowired
    OrderServiceProxy orderServiceProxy;

    public PayDTO getPaymentDetails (RequestDTO requestDTO){
        var orderId = requestDTO.getOrderId();
        OrderDTO order = orderServiceProxy.requestOrderById(orderId);
        var quantity = order.getQuantity();
        BigDecimal price = cookiePrice.multiply(BigDecimal.valueOf(quantity));
        String paymentId = orderId + "P";

        return new PayDTO(price, paymentId);
    }

    public ConfirmationDTO getConfirmation (PayDTO payDTO){

        return new ConfirmationDTO(payDTO.getPaymentId(), payDTO.getOrderPrice());
    }
}