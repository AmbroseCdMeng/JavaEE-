package test;

import org.junit.Test;

public class TestProxyPattern {
    @Test
    public void testCGLIBProxy(){
        CGLIBProxyExample cglibProxyExample = new CGLIBProxyExample();
        LeaderGaoImpl proxyObj = (LeaderGaoImpl)cglibProxyExample.bind(new LeaderGaoImpl());
        proxyObj.talkingWithCustomers();
    }
}
