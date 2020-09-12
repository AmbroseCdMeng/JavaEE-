package com.ambrose.singletonpattern.hungrysingletonpattern;


/**
 * 单例设计模式 —— 饿汉式
 */
public class HungrySingletonPattern {
    // 静态私有对象，保存单例对象。静态属于类，更好的保障单例对象的唯一性
    // 与 “懒汉式” 不同的是：饿汉式在定义时就实例化。
    private static HungrySingletonPattern instance = new HungrySingletonPattern();

    // 与 “懒汉式” 相同。私有化构造方法
    private HungrySingletonPattern(){}

    // 公开静态方法获取对象
    // 与 “懒汉式” 不同的是：饿汉式不需要判断是否为空，因为在定义时已经实例化，所以不可能为空
    public static HungrySingletonPattern getInstance(){
        return instance;
    }

    // 饿汉式不需要加锁。因为它是在类被加载时创建对象，因此线程是安全的
}
