package com.ambrose.proxypattern.jdkproxypattern;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }
}
