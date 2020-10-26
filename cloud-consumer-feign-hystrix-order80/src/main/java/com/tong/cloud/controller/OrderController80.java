package com.tong.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tong.cloud.service.PaymentService8001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController80 {
    @Autowired
    private PaymentService8001 paymentService;
    @Value("${server.port}")
    public String serverport;

    @GetMapping("/consumer/payment/success/{id}")
    public String orderForPaymentGood(@PathVariable("id") Integer id){
        return paymentService.paymentSuccess(id);
    }
    @GetMapping("/consumer/payment/error/{id}")
    @HystrixCommand
    public String orderForPaymentNotGood(@PathVariable("id") Integer id){
        return paymentService.paymentError(id);
    }

    @GetMapping("/consumer/payment/HystrixBreak/{id}")
    @HystrixCommand
    public String orderForPaymentHystrixBreak(@PathVariable("id") Integer id){
        return paymentService.paymentHystrixBreak(id);
    }


}
