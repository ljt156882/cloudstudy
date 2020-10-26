package com.tong.cloud.service;

import com.tong.cloud.service.fallback.PaymentService8001Fallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentService8001Fallback.class)
@Component
public interface PaymentService8001 {
    @GetMapping("/payment/success/{id}")
    public String paymentSuccess(@PathVariable("id") Integer id);

    @GetMapping("/payment/error/{id}")
    public String paymentError(@PathVariable("id") Integer id);

    @GetMapping("/payment/circuit/{id}")
    public String paymentHystrixBreak(@PathVariable("id") Integer id);
}
