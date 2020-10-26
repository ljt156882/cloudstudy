package com.tong.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFeignConfig {

    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
