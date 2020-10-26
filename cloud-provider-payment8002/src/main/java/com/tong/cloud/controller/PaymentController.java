package com.tong.cloud.controller;



import com.tong.cloud.pojo.MyResult;
import com.tong.cloud.pojo.Payment;
import com.tong.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverport;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/select/{id}")
    public MyResult getPayment(@PathVariable("id") Integer id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){
            return new MyResult<Payment>(200,"查找成功"+serverport,payment);
        }else{
            return new MyResult<Payment>(444,"查找失败",null);
        }
    }

    @PostMapping("/payment/insert")
    public MyResult addPayment(@RequestBody Payment payment){
        Integer result = paymentService.addPayment(payment);
        if(result==0){
            return new MyResult<Payment>(200,"插入失败",null);
        }else{
            return new MyResult<Payment>(555,"插入成功"+serverport,null);
        }
    }

}
