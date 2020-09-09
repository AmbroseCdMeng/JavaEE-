package com.ambrose.factorypattern.abstractfactorypattern;

/**
 * 对外提供的工厂总接口
 */
public class ProductFactory implements IProductFactory {

    /**
     * 这里加入处理逻辑，不同的规则创建不同的对象
     * @param productNo
     * @return
     */
    @Override
    public IProduct createProduct(String productNo) {
        if (productNo.startsWith("Mi"))
            return new MiProductFactory().createProduct(productNo);
        if (productNo.startsWith("Hw"))
            return new HwProductFactory().createProduct(productNo);
        return null;
    }
}
