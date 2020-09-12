package com.ambrose.singletonpattern.twolocksingletonpattern;

/**
 * 单例设计模式 —— 双重锁校验
 */
public class TwoLockSingletonPattern {
    // 对象锁。使用 volatile 来保障
    private volatile static TwoLockSingletonPattern instance;

    // 私有化构造方法
    private TwoLockSingletonPattern() {
    }

    // 公开静态方法获取对象
    public static TwoLockSingletonPattern getInstance() {
        // 第一次判断，在单例对象已经存在的情况下，避免进入同步代码块，提升效率
        if (instance == null)
            // 如果单例对象为空，为避免多线程情况下判断异常，加入同步锁
            synchronized (TwoLockSingletonPattern.class) {
                // 加入同步锁后，再次进行判断单例对象是否为空
                if (instance == null)
                    return new TwoLockSingletonPattern();
            }
        return instance;
    }
}
