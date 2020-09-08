package com.ambrose.observablepattern.observablepattern;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者对象
 *
 *  京东商城
 *
 *      观察者对象，需要实现 java.util.Observer 接口
 */
public class JDObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String product = (String)arg;
        System.out.println( product + "已成功推送到【京东商城】");
    }
}
