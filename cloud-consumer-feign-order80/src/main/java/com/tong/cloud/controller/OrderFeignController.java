package com.tong.cloud.controller;

import com.tong.cloud.feign.PaymentFeignService;

import com.tong.cloud.pojo.MyResult;
import com.tong.cloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentService;

    @GetMapping("/consumer/payment/{id}")
    public MyResult<Payment> getPayment(@PathVariable("id") Integer id){
        return paymentService.getPayment(id);

    }
}
