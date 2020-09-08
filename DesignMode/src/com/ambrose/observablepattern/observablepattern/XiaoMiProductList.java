package com.ambrose.observablepattern.observablepattern;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * 被观察者对象
 *
 * 小米官方旗舰店产品列表
 *
 *      被观察者对象，需要继承 java.util.Observable 类
 *
 *      1、作为被观察者，要全局使用，且为了防止出现数据混乱，需要保证只有一个实例，故采用单例设计模式
 *
 *
 */
public class XiaoMiProductList extends Observable {

    // 产品列表
    private List<String> productList = null;

    /**
     * 单例模式部分
     */
    // 保存类的实例
    private static XiaoMiProductList instance;

    // 私有化构造方法
    private XiaoMiProductList(){}

    // 获取类的实例
    public static XiaoMiProductList getInstance(){
        if(instance == null) {
            instance = new XiaoMiProductList();
            instance.productList = new ArrayList<String>();
        }
        return instance;
    }

    /**
     * 观察者模式部分
     */
    /**
     * 增加观察者对象
     * @param observable
     */
    public void addObserver(Observable observable){
        this.addObserver(observable);
    }

    public void addProduct(String product){
        productList.add(product);
        System.out.println("小米商城新推出产品：" + product);
        // 设置被观察者对象为“改变”状态
        this.setChanged();
        // 通知观察者对象数据已发生变化，进行对应操作
        this.notifyObservers(product);
    }

}
