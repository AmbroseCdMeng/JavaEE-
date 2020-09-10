package com.ambrose.builderpattern.builderpattern;

/**
 * 装配类（用于构建使用生产接口的对象）
 */
public class ComputerConstructor {
    public Computer constructorComputer(ComputerBuilder computerBuilder) {
        computerBuilder.buildSystemBoard();
        computerBuilder.buildCPU();
        computerBuilder.buildMemory();
        computerBuilder.buildDisk();
        computerBuilder.buildMonitor();
        computerBuilder.buildKeyBoard();

        return computerBuilder.buildComputer();
    }
}
