package com.ambrose.adapterpattern.objectadapterpattern;

public class Source1 extends Adapter {
    @Override
    public void runOnChrome(){
        System.out.println("Chrome 浏览器完美运行");
    }
}
