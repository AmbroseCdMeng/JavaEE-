package com.ambrose.observablepattern.observablepattern;

import org.junit.Test;

public class TestObservablePattern {
    @Test
    public void testObservablePattern(){
        // 获取被观察者对象（单例模式）
        XiaoMiProductList observable = XiaoMiProductList.getInstance();
        // 获取观察者对象
        JDObserver jd = new JDObserver();
        TBObserver tb = new TBObserver();
        PDDObserver pdd = new PDDObserver();

        // 被观察者对象中添加观察者对象
        observable.addObserver(jd);
        observable.addObserver(tb);
        observable.addObserver(pdd);

        // 发布新产品
        observable.addProduct("小米 10 Pro 至尊版");
        observable.addProduct("Red mi K30 尊享版");
    }
}
