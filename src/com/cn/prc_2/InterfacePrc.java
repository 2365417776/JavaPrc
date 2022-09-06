package com.cn.prc_2;

public class InterfacePrc{
    public static void main(String[] args) {
        Father father = Father.getInstance();
        father.action();
        father.action2();
        //创建一台电脑类
        Computer computer = new Computer(new Printer());
        computer.work();
    }
}
interface Father{
    public String msg = "这是一个父类的接口";
    //定义抽象方法
    public void action();
    //使用default定义可被重写的方法
    public default void action2(){
        System.out.println("父类方法可以被重写");
    }
    //使用static定义静态方法
    public static Father getInstance(){
        return new Son();
    }
}
class Son implements Father{
    public void action(){
        System.out.println("这是一个被重写的接口方法");
    }
}

interface IUSB{
    public boolean check();
    public void work();
}
abstract class IUSBExtend implements IUSB{

}

class Computer{
    private IUSB iusb;
    public Computer(IUSB iusb){
        this.iusb = iusb;
    }
    public void work(){
        if(iusb.check()){
            iusb.work();
        }else{
            System.out.println("设备出现故障，无法使用");
        }
    }
}

class Printer extends IUSBExtend{
    @Override
    public boolean check(){
        return false;
    }
    @Override
    public void work(){
        System.out.println("打印机开始工作");
    }
}

