package com.tong.cloud.service.fallback;

import com.tong.cloud.service.PaymentService8001;
import org.springframework.stereotype.Component;

@Component
public class PaymentService8001Fallback implements PaymentService8001 {
    @Override
    public String paymentSuccess(Integer id) {
        return "服务繁忙服务繁忙,请稍后再试sccuess";
    }

    @Override
    public String paymentError(Integer id) {
        return "服务繁忙服务繁忙,请稍后再试error";
    }

    @Override
    public String paymentHystrixBreak(Integer id) {
        return "服务繁忙服务繁忙,请稍后再试circuit";
    }
}
