package com.tong.cloud.service;


import com.tong.cloud.pojo.Payment;

public interface PaymentService {

    Payment getPaymentById(Integer id);

    Integer addPayment(Payment payment);
}
