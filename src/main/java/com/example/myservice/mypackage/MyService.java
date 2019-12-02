package com.example.myservice.mypackage;

public class MyService {

    private String prefixVerb;

    public MyService(String prefixVerb) {
        this.prefixVerb = prefixVerb;
    }

    public void setPrefixVerb(String prefixVerb) {
        this.prefixVerb = prefixVerb;
    }

    public void saySomething(String something) {
        System.out.println(prefixVerb + " " + something + "!");
    }
}
