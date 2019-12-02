package com.example.myservice.runner;

import com.example.myservice.mypackage.MyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private final MyService myService;

    public MyRunner(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(String... args) throws Exception {
        myService.saySomething("Homework");
    }
}
