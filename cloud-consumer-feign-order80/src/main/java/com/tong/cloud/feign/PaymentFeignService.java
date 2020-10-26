package com.tong.cloud.feign;

import com.tong.cloud.pojo.MyResult;
import com.tong.cloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/select/{id}")
    public MyResult<Payment> getPayment(@PathVariable("id") Integer id);
}
