package com.ambrose.proxypattern.cglibproxypattern;

import org.junit.Test;

public class TestProxyPattern {
    @Test
    public void testCGLIBProxy(){
        CglibProxyExample cglibProxyExample = new CglibProxyExample();
        ReflectServiceImpl proxyObj = (ReflectServiceImpl)cglibProxyExample.bind(new ReflectServiceImpl());
        proxyObj.sayHello("Customer");
    }
}
