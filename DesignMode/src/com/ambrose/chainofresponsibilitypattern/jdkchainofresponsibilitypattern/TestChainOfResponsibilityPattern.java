package com.ambrose.chainofresponsibilitypattern.jdkchainofresponsibilitypattern;

import org.junit.Test;

public class TestChainOfResponsibilityPattern {
    @Test
    public void testChainOfResponsibilityPattern(){
        // 老板 -- 最高层拦截器
        Audit boss = (Audit)JdkProxyExample.bind(new AuditImpl()
                , "com.ambrose.chainofresponsibilitypattern.jdkchainofresponsibilitypattern.Boss");

        // 部门经理 - 第二层拦截器
        Audit departMgr = (Audit)JdkProxyExample.bind(boss
                , "com.ambrose.chainofresponsibilitypattern.jdkchainofresponsibilitypattern.DepartmentManager");

        // 产品经理 - 第一层拦截器
        Audit productMgr = (Audit)JdkProxyExample.bind(departMgr
                ,"com.ambrose.chainofresponsibilitypattern.jdkchainofresponsibilitypattern.ProductManager");

        productMgr.auditPass();
    }
}
