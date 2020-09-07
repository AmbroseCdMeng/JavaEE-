package com.ambrose.chainofresponsibilitypattern.jdkchainofresponsibilitypattern;

import java.lang.reflect.Method;
import java.util.Random;

public class DepartmentManager implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        boolean result = new Random().nextInt(10) % 2 == 1;
        if (result)
            System.out.println("我是部门经理，这件事情我决定 —— 审核通过 ！！！");
        else
            System.out.println("我是部门经理，这件事情我决定 —— 不通过 ！！！");
        return result;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("我是部门经理，此事可行性太低，没有必要继续向上级汇报，所以驳回申请 ");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("我是部门经理，非常期待各位新颖的观点");
    }
}
