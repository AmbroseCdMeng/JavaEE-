package com.ambrose.observablepattern.observablepattern;

import java.util.Observable;
import java.util.Observer;

public class PDDObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String product = (String) arg;
        System.out.println( product + "已成功推送到【拼多多商城】");
    }
}
