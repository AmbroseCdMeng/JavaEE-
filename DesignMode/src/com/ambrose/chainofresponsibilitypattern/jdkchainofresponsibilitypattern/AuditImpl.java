package com.ambrose.chainofresponsibilitypattern.jdkchainofresponsibilitypattern;

public class AuditImpl implements Audit {
    @Override
    public void auditPass() {
        System.out.println("审核通过 ！！！");
    }
}
