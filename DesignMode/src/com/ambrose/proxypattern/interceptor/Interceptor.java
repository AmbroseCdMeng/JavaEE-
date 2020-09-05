package com.ambrose.proxypattern.interceptor;

import java.lang.reflect.Method;

/**
 * 定义拦截器接口
 */
public interface Interceptor {
    /**
     * 访问真实对象前调用
     * @param proxy 代理对象
     * @param target    真实对象
     * @param method    方法
     * @param args  运行参数
     * @return
     */
    boolean before(Object proxy, Object target, Method method, Object[] args);

    /**
     * 真实对象的方法的替代方法
     *  当访问真实对象之前，调用 before 方法，如果 before 方法执行成功，则调用真实对象的方法；
     *  但如果 before 执行失败，也就是说访问真实对象的方法时被拦截了，此时，就执行 around 方法
     */
    void around(Object proxy, Object target, Method method, Object[] args);

    /**
     * 真实对象方法或替代方法执行完成后调用
     */
    void after(Object proxy, Object target, Method method, Object[] args);
}
