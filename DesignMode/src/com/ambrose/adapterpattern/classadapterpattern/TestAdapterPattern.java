package com.ambrose.adapterpattern.classadapterpattern;

        import org.junit.Test;

public class TestAdapterPattern {
    @Test
    public void adapterPattern(){
        Targetable target = new Adapter();
        target.runOnChrome();
        target.runOnEdge();
        target.runOnFirefox();
    }
}
