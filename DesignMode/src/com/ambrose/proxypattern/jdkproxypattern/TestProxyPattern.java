package com.ambrose.proxypattern.jdkproxypattern;

import org.junit.Test;

public class TestProxyPattern {
    @Test
    public void testJdkProxy(){
        JdkProxyExample jdk = new JdkProxyExample();
        // 绑定关系，因为挂在接口 LeaderGao 下，所以声明代理对象 LeaderGao
        HelloWorld proxy = (HelloWorld)jdk.bind(new HelloWorldImpl());
        // 此时，LeaderGao 对象已经是一个代理对象，它会进入代理的逻辑方法 invoke 里
        proxy.sayHelloWorld();
    }
}
