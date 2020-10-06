package com.ambrose.adapterpattern.interfaceadapterpattern;

public class Adapter implements Targetable {

    private Source source;

    public Adapter(Source source){
        this.source = source;
    }

    @Override
    public void runOnChrome() {
        source.runOnChrome();
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
