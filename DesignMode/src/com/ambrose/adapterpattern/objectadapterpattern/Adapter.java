package com.ambrose.adapterpattern.objectadapterpattern;

public abstract class Adapter implements Targetable {
    @Override
    public void runOnChrome() {
        System.out.println("Chrome 浏览器完美运行");
    }

    @Override
    public void runOnEdge() {
        System.out.println("Edge 浏览器完美运行");
    }

    @Override
    public void runOnFirefox() {
        System.out.println("Firefox 浏览器完美运行");
    }
}
