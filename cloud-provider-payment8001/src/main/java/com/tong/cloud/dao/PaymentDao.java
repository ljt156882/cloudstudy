package com.tong.cloud.dao;


import com.tong.cloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    Payment getPaymentById(Integer id);

    Integer addPayment(Payment payment);
}
