package com.ambrose.chainofresponsibilitypattern.jdkchainofresponsibilitypattern;

import java.lang.reflect.Method;
import java.util.Random;

public class ProductManager implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        boolean result = new Random().nextInt(10) % 2 == 1;
        if (result)
            System.out.println("我是项目经理，这件事情我决定 —— 审核通过 ！！！");
        else
            System.out.println("我是项目经理，这件事情我决定 —— 不通过 ！！！");
        return result;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("我是项目经理，此事简直就是不可理喻，别想这些虚无缥缈的，回去该干啥干啥去 ");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("我是项目经理，加班加班加班~~~ ");
    }
}
