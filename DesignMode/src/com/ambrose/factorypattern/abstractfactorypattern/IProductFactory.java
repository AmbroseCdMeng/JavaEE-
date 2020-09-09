package com.ambrose.factorypattern.abstractfactorypattern;


public interface IProductFactory {
    IProduct createProduct(String productNo);
}
