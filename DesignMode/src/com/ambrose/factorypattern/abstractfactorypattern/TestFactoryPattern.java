package com.ambrose.factorypattern.abstractfactorypattern;

import org.junit.Test;

public class TestFactoryPattern {
    @Test
    public void testFactoryPattern(){
        IProduct hw = new ProductFactory().createProduct("Hw20200909001");
        IProduct mi = new ProductFactory().createProduct("Mi20200909001");
    }
}
