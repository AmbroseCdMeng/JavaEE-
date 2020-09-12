package com.ambrose.singletonpattern.staticinnersingleton;

/**
 * 单例设计模式 —— 静态内部类
 */
public class StaticInnerSingleton {
    // 私有化构造方法
    private StaticInnerSingleton(){}

    // 静态内部类创建对象并实例化
    // 类的静态内部类在 JVM 中是唯一的，这种方式极好的保证了单例对象的唯一性
    private static class SingletonHolder{
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    // 公开静态方法获取对象
    public static final StaticInnerSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
