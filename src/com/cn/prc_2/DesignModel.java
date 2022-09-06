package com.cn.prc_2;

public class DesignModel {
    public static void main(String[] args) {
        IEat eat = Factory.getInstance("apple");
        IEat eat2 = Factory.getInstance("bread");
        eat.eat();
        eat2.eat();
        //调用代理设计的食物
        IFood food = new EatProxy(new Food());
        //包装了代理类
        IFood food2 = Factory2.getInstance();
        food.eat();
        food2.eat();
    }
}