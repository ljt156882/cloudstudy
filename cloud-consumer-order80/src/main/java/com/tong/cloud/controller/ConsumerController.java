package com.tong.cloud.controller;

import com.tong.cloud.pojo.MyResult;
import com.tong.cloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;




    @GetMapping("/consumer/payment/{id}")
    public MyResult<Payment> getPayment(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/select/"+id, MyResult.class);

    }

    @GetMapping("/consumer/payment/create")
    public MyResult<Payment> addPayment(Payment payment){
         return restTemplate.postForObject(PAYMENT_URL+"/payment/insert",payment,MyResult.class);

    }
}
