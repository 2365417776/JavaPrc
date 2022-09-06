package com.cn.prc_2;

public class polymorphic {
    public static void main(String[] args) {
        test1(new Dog("小黑", 3));
        test1(new Cat("小白", 5));
        Animal dog1 = new Dog("旺财", 5);
        Animal dog2 = dog1;
        Animal dog3 = new Dog("大黄", 4);
        System.out.println(dog1.equals(dog2));
        System.out.println(dog1.equals(dog3));
    }
    //多态的练习
    public static void test1(Animal animal){
        animal.action();
        if(animal instanceof Dog){
            Dog dog = (Dog) animal;
            dog.Watch();
        }
        if(animal instanceof Cat){
            Cat cat = (Cat) animal;
            cat.Cute();
        }
        System.out.println("----------");
    }
}
abstract class Animal{
    public String name;
    public int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Animal(){}
    public abstract void action();
}

class Dog extends Animal{
    public Dog(String name, int age){
        super(name, age);
    }
    @Override
    public void action(){
        System.out.println(name + "-----" + age);
        System.out.println("狗吃肉，吃得很香，汪汪叫");
    }

    public void Watch(){
        System.out.println("狗看门，汪汪叫");
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Animal)){
            return false;
        }
        if(obj == null)
            return false;
        if(this == obj)
            return true;
        Dog dog = (Dog)obj;
        return this.name.equals(dog.name) && this.age == dog.age;
    }
}

class Cat extends Animal{
    public Cat(String name, int age){
        super(name, age);
    }
    @Override
    public void action(){
        System.out.println(name + "-----" + age);
        System.out.println("猫吃鱼，吃得很香，喵喵叫");
    }

    public void Cute(){
        System.out.println("小猫咪，喵喵叫，好可爱");
    }
}
