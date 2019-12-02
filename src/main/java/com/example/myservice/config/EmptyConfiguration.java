package com.example.myservice.config;

import com.example.myservice.mypackage.MyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmptyConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MyService myService() {
        return new MyService("Do");
    }
}
