package com.ambrose.proxypattern.interceptor;

public class LeaderGaoImpl implements LeaderGao {
    @Override
    public void talkingWithCustomers() {
        System.out.println("与客户洽谈中 ...");
    }
}