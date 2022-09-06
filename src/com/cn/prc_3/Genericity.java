package com.cn.prc_3;

import org.junit.Test;
import com.yuan.hello.Hello;

public class Genericity {
    public static void main(String[] args) {
        Message<String> msg = new Message<String>();
        msg.setMessage("123");
        fun(msg);
        Integer[] arr = fun2(11, 22, 33, 44);
        for(int a:arr){
            System.out.print(a + " ");
        }
        Hello hello = new Hello();
        hello.hello();
        Hello.hello2();
    }
    public static void fun(Message<? super String> message){
        System.out.println(message.getMessage());
    }
    //定义一个泛型方法
    public static<T extends Number> T[] fun2(T... args){
        return args;
    }
    @Test
    public void test01(){
        System.out.println("Hello World");
        //泛型的设计
        Point<Integer> point = new Point<Integer>();
        point.setX(23);
        point.setY(12);
        System.out.println(point.getX() + "-----" + point.getY());

    }

}
//泛型的设计
class Point<T>{
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}
class Message<T extends String>{
    private T message;
    public void setMessage(T message){
        this.message = message;
    }
    public T getMessage(){
        return message;
    }
}
