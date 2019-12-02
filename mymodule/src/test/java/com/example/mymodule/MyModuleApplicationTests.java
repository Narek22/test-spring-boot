package com.example.mymodule;

import com.example.myservice.config.EmptyConfiguration;
import com.example.myservice.mypackage.MyService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.hamcrest.Matchers.containsString;


class MyModuleApplicationTests {

    OutputCaptureRule outputCaptureRule = new OutputCaptureRule();

    private ConfigurableApplicationContext context;

    @AfterEach
    void closeContext() {
        if (context != null) {
            context.close();
        }
    }

    @Test
    void contextLoads() {
        load(UserConfiguration.class);
        MyService myService = context.getBean(MyService.class);
        myService.saySomething("guitar");
        outputCaptureRule.expect(containsString("Play guitar!"));
    }

    private void load(Class<?> configClass, String... environment) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(configClass);
        ctx.refresh();
        context = ctx;
    }

    @ImportAutoConfiguration(EmptyConfiguration.class)
    static class MyAutoConfiguration {

    }

    @Configuration
    @Import(MyAutoConfiguration.class)
    static class UserConfiguration {
        @Bean
        public MyService myService() {
            return new MyService("Play");
        }
    }
}
