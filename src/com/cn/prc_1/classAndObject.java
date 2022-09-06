package com.cn.prc_1;

public class classAndObject {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setScore(88.5);
        System.out.println(person);
    }
}

class Person{
    private String name;
    private int age;
    private double score;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
