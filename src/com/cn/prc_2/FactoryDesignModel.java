package com.cn.prc_2;

public class FactoryDesignModel {
}
//工厂设计模式
interface IEat{
    public void eat();
}
class Bread implements IEat{
    @Override
    public void eat(){
        System.out.println("正在吃面包，面包很好吃！");
    }
}
class Apple implements  IEat{
    @Override
    public void eat(){
        System.out.println("正在吃苹果，苹果很好吃");
    }
}
//这是一个工厂类，用来生产产品
class Factory{
    private static IEat eat;
    public static IEat getInstance(String food){
        if("bread".equals(food)){
            eat = new Bread();
        }
        if("apple".equals(food)){
            eat = new Apple();
        }
        return eat;
    }
}
