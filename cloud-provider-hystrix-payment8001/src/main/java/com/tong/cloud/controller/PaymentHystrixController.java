package com.tong.cloud.controller;

import com.tong.cloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;
    @Value("${server.port}")
    public String serverport;
    @GetMapping("/payment/success/{id}")
    public String paymentSuccess(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentSuccess(id);
    }

    @GetMapping("/payment/error/{id}")
    public String paymentError(@PathVariable("id") Integer id){
        return serverport+paymentHystrixService.paymentError(id);
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentHystrixBreak(@PathVariable("id") Integer id){
        return serverport+paymentHystrixService.paymentCircuitBreaker(id);
    }



}
