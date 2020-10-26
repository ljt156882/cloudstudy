package com.tong.cloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentHystrixService {

    String paymentSuccess(Integer id);

    String paymentError(Integer id);

    String paymentCircuitBreaker(Integer id);


    }
