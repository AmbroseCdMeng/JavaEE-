package com.ambrose.proxypattern.jdkproxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {

    //真实对象
    private Object target = null;

    /**
     * 建立代理对象和真实对象的代理关系，并返回代理对象
     * @param target 真实对象
     * @return 代理对象
     */
    public Object bind(Object target){
        // 保存真实对象
        this.target = target;
        // 建立并生成代理对象
        /* Proxy.newProxyInstance 方法需要三个参数：
            1、类加载器。
                这里采用 target 类本身的加载器
            2、表示最终生成的动态代理对象挂载在哪些接口下。
                这里将其挂在 target 类实现的接口下
            3、定义实现方法逻辑的代理类，必须实现 InvocationHandler 的 invoke 方法
                这里 this 表示当前对象
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this );
    }

    /**
     * 代理方法逻辑
     * @param proxy 代理对象（就是 bind 方法生成的对象）
     * @param method    当前调度的方法
     * @param args  当前调度方法参数
     * @return  代理结果返回
     * @throws Throwable    异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        Object obj = method.invoke(target, args);
        System.out.println("在调度真实对象之后的服务");
        return obj;
    }
}
