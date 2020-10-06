package com.ambrose.adapterpattern.interfaceadapterpattern;

import org.junit.Test;

public class TestAdapterPattern {
    @Test
    public void adapterPattern(){
        Targetable target = new Adapter(new Source());
        target.runOnChrome();
        target.runOnEdge();
        target.runOnFirefox();
    }
}
