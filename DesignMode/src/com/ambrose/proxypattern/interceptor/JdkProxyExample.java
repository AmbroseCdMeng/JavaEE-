package com.ambrose.proxypattern.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 在 JDK 动态代理中使用 [拦截器] 示例
 */
public class JdkProxyExample implements InvocationHandler {

    // 真实对象
    private Object target = null;
    // 拦截器全限定名
    private String interceptorClass = null;

    /**
     * 构造方法。
     *  在这里，构造方法中，传入真实对象，与拦截器的名称。
     *
     *  至于为什么需要这样一个带参构造方法？ 因为创建代理对象时需要使用到拦截器全限定名
     *  详见 bind 方法中的注释
     * @param target
     * @param interceptorClass
     */
    public JdkProxyExample(Object target, String interceptorClass){
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 建立代理对象和真实对象的代理关系，并返回代理对象
     *
     *
     * @param target
     * @param interceptorClass
     * @return
     */
    public static Object bind(Object target, String interceptorClass){
        /* Proxy.newProxyInstance 方法需要三个参数：
            1、类加载器。
                这里采用 target 类本身的加载器
            2、表示最终生成的动态代理对象挂载在哪些接口下。
                这里将其挂在 target 类实现的接口下
            3、定义实现方法逻辑的代理类，必须实现 InvocationHandler 的 invoke 方法
               在单纯 jdk 动态代理中，我们使用 this 作为方法逻辑类，
               但是这里既然要使用拦截器，我们就不能直接使用 this 作为方法逻辑类，
               而要提供一个带参构造方法，将拦截器名作为参数传递给构造方法，然后使用带参构造方法创建该类对象

            ☆ 这里还有一个变化：因为建立代理对象时，直接传入当前类的带参构造对象作为逻辑代理类，
               在其他方法中可以无需调用该类的构造方法创建对象，只需要调用 bind 方法获取代理对象即可。
               所以，这里的 bind 方法可以直接标识为 static
         */
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new JdkProxyExample(target, interceptorClass));
    }

    /**
     * 代理方法逻辑。
     * 通过代理对象调用方法，首先会进入该方法。所以对拦截器的处理就应该写在这里。
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 如果拦截器为空
        if (interceptorClass == null)
            // 直接反射原真实对象方法
            return method.invoke(target, args);
        // 拦截器不为空
        // 通过反射生成拦截器对象
        Interceptor interceptor = (Interceptor)Class.forName(interceptorClass).newInstance();

        // 调用拦截器前置方法，返回 before 方法的执行状态，如果返回 false，则说明执行中止，即拦截成功，反之，如果返回 true，则拦截失败
        boolean before = interceptor.before(proxy, target, method, args);
        // 定义一个对象存储执行结果
        Object result = null;
        // 如果拦截失败，调用原真实对象方法
        if (before)
            result = method.invoke(target, args);
        else
        // 如果拦截成功，调用拦截器的 around 方法
            interceptor.around(proxy, target, method, args);
        // 调用拦截器后置方法
        interceptor.after(proxy, target, method, args);
        return result;
    }
}
