package com.ambrose.chainofresponsibilitypattern.jdkchainofresponsibilitypattern;

import java.lang.reflect.Method;
import java.util.Random;

public class Boss implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        boolean result = new Random().nextInt(10) % 2 == 1;
        if (result)
            System.out.println("我是老板，这件事情我决定 —— 审核通过 ！！！");
        else
            System.out.println("我是老板，这件事情我决定 —— 不通过 ！！！");
        return result;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("我是老板，此事成本较大，风险较高，可行性较低，所以驳回申请 ");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("我是老板，欢迎下次继续提出新的想法");
    }
}
