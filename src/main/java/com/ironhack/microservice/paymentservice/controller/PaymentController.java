package com.ironhack.microservice.paymentservice.controller;

import com.ironhack.microservice.paymentservice.dto.ConfirmationDTO;
import com.ironhack.microservice.paymentservice.dto.PayDTO;
import com.ironhack.microservice.paymentservice.dto.RequestDTO;
import com.ironhack.microservice.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/details")
    public PayDTO getPaymentDetails (RequestDTO requestDTO){
        return paymentService.getPaymentDetails(requestDTO);
    }

    @GetMapping("/confirmation")
    public ConfirmationDTO getConfirmation (PayDTO payDTO){
        return paymentService.getConfirmation(payDTO);
    }
}
