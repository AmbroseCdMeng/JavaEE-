package com.ambrose.factorypattern.abstractfactorypattern;

public class MiProductFactory implements IProductFactory {
    @Override
    public IProduct createProduct(String productNo) {
        // Mi 工厂生成对象的规则，可以自定义处理
        IProduct product = new XiaoMi();
        System.out.println("小米，为发烧而生！" + productNo);
        return product;
    }
}
