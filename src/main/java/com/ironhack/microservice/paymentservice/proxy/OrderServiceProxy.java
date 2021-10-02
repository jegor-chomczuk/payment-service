package com.ironhack.microservice.paymentservice.proxy;

import com.ironhack.microservice.paymentservice.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ORDER-SERVICE")
public interface OrderServiceProxy {

    @GetMapping("orders/{id}")
    OrderDTO requestOrderById (@PathVariable("id") Long id);
}