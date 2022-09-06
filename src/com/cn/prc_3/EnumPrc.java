package com.cn.prc_3;

import org.junit.Test;

public class EnumPrc {
    @Test
    public void test01(){
        Color c = Color.RED;
        System.out.println(c);
        for(Color cc : Color.values()){
            System.out.println(cc.name() + "---" + cc.ordinal());
        }
    }

    @Test
    public void test02(){
        for(Color c : Color.values()){
            System.out.println(c + c.getMessage());
        }
    }

    @Test
    public void test03(){
        Person person = new Person("小月", 18, Sex.FEMALE);
        System.out.println(person);
    }
}

enum Color{
    RED("红"){
        @Override
        public String getMessage(){
            return RED + "【message】";
        }
    }, GREEN("绿"){
        @Override
        public String getMessage(){
            return GREEN + "【message】";
        }
    }, BLUE("蓝"){
        @Override
        public String getMessage(){
            return BLUE + "【message】";
        }
    };
    private String title;
    private Color(String title){
        this.title = title;
    }
    @Override
    public String toString(){
        return title;
    }
    //枚举中定义抽象方法
    public abstract String getMessage();
}
enum Sex{
    MALE("男"), FEMALE("女");
    private String title;
    private Sex(String title){
        this.title = title;
    }
    @Override
    public String toString(){
        return title;
    }
}
class Person{
    private String name;
    private int age;
    private Sex sex;
    public Person(String name, int age, Sex sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    @Override
    public String toString(){
        return name + " " + age + " " + sex;
    }
}