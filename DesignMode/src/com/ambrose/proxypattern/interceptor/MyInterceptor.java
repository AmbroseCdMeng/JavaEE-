package com.ambrose.proxypattern.interceptor;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * 自定义拦截器实现类，实现拦截器接口
 */
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        // 生成一个随机 boolean 值。
        // 为 true 时表示通过，未拦截，调用真实对象方法（允许访问高总）
        // 为 false 时表示执行终端，拦截成功，调用替代方法 around （不允许访问高总）
        boolean result = new Random().nextInt(10) % 2 == 1;
        System.out.println("方法前逻辑 —— 小彭接待了客户   " + "小彭认为客户" + (result ? "有权" : "无权") + "访问高总" );
        return result;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("替代方法执行 —— 小彭对客户说：您的项目太小了，请回吧！");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("方法后逻辑 —— 小彭负责送客：您慢走~");
    }
}

