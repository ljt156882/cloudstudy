package com.tong.cloud.controller;



import com.tong.cloud.pojo.MyResult;
import com.tong.cloud.pojo.Payment;
import com.tong.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverport;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private PaymentService paymentService;
    @GetMapping("/payment/select/{id}")
    public MyResult<Payment> getPayment(@PathVariable("id") Integer id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){
            return new MyResult<Payment>(200,"查找成功"+serverport,payment);
        }else{
            return new MyResult<Payment>(444,"查找失败",null);
        }
    }

    @PostMapping("/payment/insert")
    public MyResult<Payment> addPayment(@RequestBody Payment payment){
        Integer result = paymentService.addPayment(payment);
        if(result==0){
            return new MyResult<Payment>(200,"插入失败");
        }else{
            return new MyResult<Payment>(555,"插入成功"+serverport);
        }
    }

    @GetMapping("/services/message")
    public Object servicesMessage(){
        List<String> services = discoveryClient.getServices();
        for (String service:services) {
          log.info("service"+service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance:instances) {
                log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            }
        }
        return discoveryClient;
    }
}
