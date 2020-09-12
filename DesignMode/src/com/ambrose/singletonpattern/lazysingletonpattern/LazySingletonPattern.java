package com.ambrose.singletonpattern.lazysingletonpattern;

/**
 * 单例设计模式 —— 懒汉式
 */
public class LazySingletonPattern {
    // 静态私有对象，保存单例对象。静态属于类，更好的保障单例对象的唯一性
    private static LazySingletonPattern instance;

    // 私有化构造方法
    private LazySingletonPattern(){}

    // 公开静态方法获取对象
//    public static LazySingletonPattern getInstance(){
//        if(instance == null)
//            instance = new LazySingletonPattern();
//        return instance;
//    }

    // 建议加锁，在多线程中更安全
    public static synchronized LazySingletonPattern getInstance(){
        if(instance == null)
            instance = new LazySingletonPattern();
        return instance;
    }
}
