package com.ambrose.builderpattern.builderpattern;

/**
 * 生产类
 */
public class ComputerBuilder implements IComputerBuilder {

    Computer computer = null;

    public ComputerBuilder(){
        this.computer = new Computer();
    }

    @Override
    public void buildSystemBoard() {
        System.out.println("生产主板 ...");
        computer.setSystemBoard("技嘉Z490 AORUS XTREME WATERFORCE");
    }

    @Override
    public void buildCPU() {
        System.out.println("生产CPU ...");
        computer.setCPU("AMD Ryzen 9 3900X");
    }

    @Override
    public void buildMemory() {
        System.out.println("生产内存 ...");
        computer.setMemory("Kingston-骇客神条 16G * 4");
    }

    @Override
    public void buildDisk() {
        System.out.println("生产硬盘 ...");
        computer.setDisk("SAMSUNG 860 DCT 3.84TB SATA3 SSD");
    }

    @Override
    public void buildMonitor() {
        System.out.println("生产显示器 ...");
        computer.setMonitor("SAMSUNG C24FG70FQ");
    }

    @Override
    public void buildKeyBoard() {
        System.out.println("生产键盘 ...");
        computer.setKeyBoard("Cherry MX2.0S RGB");
    }

    @Override
    public Computer buildComputer(){
        return computer;
    }
}
