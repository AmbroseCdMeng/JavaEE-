package test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *
 */
public class CGLIBProxyExample implements MethodInterceptor {
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
        System.out.println("进入代理逻辑方法 —— 见到了代理人小彭");
        System.out.println("在访问真实对象之前 —— 接待客人并筛选客人是否可以访问高总");
        Object obj = methodProxy.invokeSuper(proxy, args);
        System.out.println("在访问真实对象之后 —— 送客");
        return obj;
    }
}
