package com.ambrose.adapterpattern.objectadapterpattern;

import org.junit.Test;

public class TestAdapterPattern {
    @Test
    public void adapterPattern(){
        Adapter source1 = new Source1();
        Adapter source2 = new Source2();
        source1.runOnChrome();
        source2.runOnEdge();
        source2.runOnChrome();
        source2.runOnFirefox();
    }
}
