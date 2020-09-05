package com.ambrose.proxypattern.interceptor;

import org.junit.Test;

public class TestInterceptorProxyPattern {
    @Test
    public void testInterceptorJdkProxyPattern(){
        // 获取代理对象。调用 JdkProxyExample 的静态方法 bind，传入真实对象和拦截器全限定名
        LeaderGao proxy = (LeaderGao) JdkProxyExample.bind(
                new LeaderGaoImpl(),
                "com.ambrose.proxypattern.interceptor.MyInterceptor"
        );
        // 运行代理对象的方法
        proxy.talkingWithCustomers();
    }
}
