package com.ambrose.proxypattern.cglibproxypattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyExample implements MethodInterceptor {

    // 定义全局变量，保存真实对象
    private Object target = null;
    /**
     * 生成 CGLIB 代理对象
     * @param target 真实对象
     * @return  真实对象的 CGLIB 代理对象
     */
    public Object bind(Object target){
        this.target = target;
        // CGLIB 的增强类对象 enhancer
        Enhancer enhancer = new Enhancer();
        // 设置增强类型
        enhancer.setSuperclass(this.target.getClass());
        // 定义代理逻辑对象为当前对象 this。要求当前对象必须实现 MethodInterceptor 接口（intercept 方法）
        enhancer.setCallback(this);
        // 设置类加载器
        enhancer.setClassLoader(target.getClass().getClassLoader());
        // 生成并返回代理对象
        return enhancer.create();
    }

    /**
     * 代理逻辑方法
     * @param proxy 代理对象
     * @param method    方法
     * @param args  方法参数
     * @param methodProxy   方法代理
     * @return  代理逻辑返回
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable{
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        Object obj = methodProxy.invokeSuper(proxy, args);
        System.out.println("在调度真实对象之后的服务");
        return obj;
    }
}
