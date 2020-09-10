package com.ambrose.builderpattern.builderpattern;

/**
 * 生产接口（描述产品装配过程）
 */
public interface IComputerBuilder {
    // 生产主板
    void buildSystemBoard();
    // 生产CPU
    void buildCPU();
    // 生产内存
    void buildMemory();
    // 生产硬盘
    void buildDisk();
    // 生产显示器
    void buildMonitor();
    // 生产键盘
    void buildKeyBoard();

    // 生产电脑
    Computer buildComputer();
}
