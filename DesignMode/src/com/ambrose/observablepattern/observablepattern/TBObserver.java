package com.ambrose.observablepattern.observablepattern;

import java.util.Observable;
import java.util.Observer;

public class TBObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String product = (String) arg;
        System.out.println( product + "已成功推送到【淘宝商城】");
    }
}
