package com.ambrose.factorypattern.simplefactorypattern;

public class ProductFactory {
    public static IProduct createProduct(String poId){
        if ("Mi".equals(poId))
            return new XiaoMi();
        if ("Hw".equals(poId))
            return new HuaWei();
        return null;
    }
}
