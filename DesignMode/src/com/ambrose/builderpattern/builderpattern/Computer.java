package com.ambrose.builderpattern.builderpattern;

/**
 * 要创建的产品
 */
public class Computer {
    // 主板
    private String systemBoard;
    // CPU
    private String CPU;
    // 内存
    private String memory;
    // 硬盘
    private String disk;
    // 显示器
    private String monitor;
    // 键盘
    private String keyBoard;

    /* Getter & Setter */

    public String getSystemBoard() {
        return systemBoard;
    }

    public void setSystemBoard(String systemBoard) {
        this.systemBoard = systemBoard;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(String keyBoard) {
        this.keyBoard = keyBoard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "systemBoard='" + systemBoard + '\'' +
                ", CPU='" + CPU + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                ", monitor='" + monitor + '\'' +
                ", keyBoard='" + keyBoard + '\'' +
                '}';
    }
}
