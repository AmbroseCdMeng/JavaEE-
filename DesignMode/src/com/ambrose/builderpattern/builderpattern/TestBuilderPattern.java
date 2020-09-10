package com.ambrose.builderpattern.builderpattern;

import org.junit.Test;

public class TestBuilderPattern {
    @Test
    public void testBuilderPattern(){
        // 创建生产类对象，创建各个组件（创建简单对象）
        ComputerBuilder builder = new ComputerBuilder();
        // 创建装配类对象，准备组装各个组件（装配简单对象）
        ComputerConstructor constructor = new ComputerConstructor();

        // 调用装配类的组装方法，返回产品对象（返回装配后复杂对象）
        Computer computer = constructor.constructorComputer(builder);

        // 输出复杂对象
        System.out.println(computer);
    }
}
