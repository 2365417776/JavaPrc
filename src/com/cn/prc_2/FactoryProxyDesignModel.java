package com.cn.prc_2;

public class FactoryProxyDesignModel {
}
//代理设计模式
interface IFood{
    public void eat();
}
class Food implements IFood{
    public void eat(){
        System.out.println("这是一个代理工厂生产出的食物");
    }
}
class EatProxy implements IFood{
    private IFood iFood;
    public EatProxy(IFood iFood){
        this.iFood = iFood;
    }
    public void eat(){
        prepare();
        iFood.eat();
        clear();
    }

    public void prepare(){
        System.out.println("【代理主题】1、精心购买食物");
        System.out.println("【代理主题】2、小心处理食材");
    }
    public void clear(){
        System.out.println("【代理主题】3、收拾碗筷");
    }
}
class Factory2{
    private static IFood iFood;
    public static IFood getInstance(){
        iFood = new EatProxy(new Food());
        return iFood;
    }
}

