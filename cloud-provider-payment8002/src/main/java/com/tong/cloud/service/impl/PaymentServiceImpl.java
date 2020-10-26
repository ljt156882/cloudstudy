package com.tong.cloud.service.impl;


import com.tong.cloud.dao.PaymentDao;
import com.tong.cloud.pojo.Payment;
import com.tong.cloud.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;
    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public Integer addPayment(Payment payment) {

        return paymentDao.addPayment(payment);
    }
}
