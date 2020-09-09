package com.ambrose.factorypattern.abstractfactorypattern;

public class HwProductFactory implements IProductFactory {
    @Override
    public IProduct createProduct(String productNo) {
        // Hw 工厂生成对象的规则，可以自定义处理
        IProduct product = new HuaWei();
        System.out.println("华为，非极致而不为！" + productNo);
        return product;
    }
}
