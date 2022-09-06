package com.cn.prc_2;

import org.junit.Test;

public class singleDesignModel {
    @Test
    public void test01(){
        Singleton singleton = null;
        singleton = Singleton.getInstance();
        singleton.print();
    }
    @Test
    public void test02(){
        Singleton2 singleton2 = null;
        singleton2 = Singleton2.getInstance();
        singleton2.print();
    }
    @Test
    public void test03(){
        Color red = Color.getInstance("red");
        Color green = Color.getInstance("green");
        Color blue = Color.getInstance("blue");
        System.out.println(red + " " + green + " " + blue);
    }
}

/**
 * 饿汉式单例设计模式
 * 定义成员属性时进行实例化对象
 */
class Singleton{
    private static final Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return singleton;
    }
    public void print(){
        System.out.println("这是一个饿汉式的单例设计");
    }
}

/**
 * 懒汉式单例设计模式
 * 使用时再创建对象
 */
class Singleton2{
    private static Singleton2 singleton;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if(singleton == null){
            singleton = new Singleton2();
        }
        return singleton;
    }
    public void print(){
        System.out.println("我是一个懒汉式的单例设计模式");
    }
}

/**
 * 多例设计模式
 */
class Color{
    private static final Color RED = new Color("红");
    private static final Color GREEN = new Color("绿");
    private static final Color BLUE = new Color("蓝");
    private String title;
    private Color(String title){
        this.title = title;
    }
    public static Color getInstance(String color){
        switch (color){
            case "red":
                return RED;
            case "green":
                return GREEN;
            case "blue":
                return BLUE;
            default:
                return null;
        }
    }
    @Override
    public String toString(){
        return title;
    }
}
