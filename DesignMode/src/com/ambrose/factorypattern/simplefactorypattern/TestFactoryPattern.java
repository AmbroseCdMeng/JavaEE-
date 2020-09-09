package com.ambrose.factorypattern.simplefactorypattern;

import org.junit.Test;

public class TestFactoryPattern {
    @Test
    public void testFactoryPattern(){
        IProduct mi = ProductFactory.createProduct("Mi");
        IProduct hw = ProductFactory.createProduct("Hw");

        System.out.println(mi.getClass().getName());
        System.out.println(hw.getClass().getName());
    }
}