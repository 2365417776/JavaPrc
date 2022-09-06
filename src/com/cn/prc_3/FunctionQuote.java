package com.cn.prc_3;

import org.junit.Test;
//导入内建函数式接口开发包
import java.util.function.*;

public class FunctionQuote {
    @Test
    public void test01(){
        //引用静态方法 String 中的valueOf方法(valueOf可以将int转为String类型)
        IFunction01<Integer, String> myMethod01 = String::valueOf;
        String result = myMethod01.change(100);
        System.out.println(result);
    }
    @Test
    public void test02(){
        //引用普通方法 String 中的toUpperCase()方法
        IFunction02<String> myMethod02 = "Hello World"::toUpperCase;
        String result = myMethod02.set();
        System.out.println(result);
    }
    @Test
    public void test03(){
        //引用特定类的普通方法 String 中的comPareTo(String parm)方法
        IFunction03<String> myMethod03 = String::compareTo;
        System.out.println(myMethod03.compare("H", "p"));
    }
    @Test
    public void test04(){
        //引用构造方法
        IFunction04<Person3> myMethod04 = Person3::new;
        System.out.println(myMethod04.structure("小月", 18));
    }
    @Test
    public void test05(){
        //使用功能型函数式接口 实现对public boolean startsWith(String str)的引用
        //功能型函数式接口，一个参数，一个返回值
        Function<String, Boolean> method01 = "Hello"::startsWith;
        System.out.println(method01.apply("G"));
    }
    @Test
    public void test06(){
        //使用消费型函数接口 实现对System.out.Println的引用
        //消费型函数式接口，只有一个参数，没有返回值, 只处理数据，不返回结果
        Consumer<String> method02 = System.out::println;
        method02.accept("Hello World");
    }
    @Test
    public void test07(){
        //使用供给型函数式接口 实现对toLowerCase()函数的引用
        //供给型函数式接口，只有返回值，没有参数值
        Supplier<String> method03 = "Hello World"::toLowerCase;
        System.out.println(method03.get());
    }
    @Test
    public void test08(){
        //使用断言式函数式接口 实现对equalsIgnoreCase(String str)的引用
        //断言式函数接口，只有一个参数，返回一个boolean的值
        Predicate<String> method04 = "hello"::equalsIgnoreCase;
        System.out.println(method04.test("HELLO"));
    }
}
/**
 * 方法引用
 * 需要创建函数式接口
 */

/**
 * 接口1 需要一个参数，并且有一个返回值
 * @param <P> 代表参数
 * @param <R> 代表返回值
 */
interface IFunction01<P, R>{
    public R change(P p);
}

/**
 *
 * @author 23654
 * @param <R> 返回值
 */
interface IFunction02<R>{
    public R set();
}

interface IFunction03<P>{
    public int compare(P p1, P p2);
}

interface IFunction04<R>{
    public R structure(String a, int b);
}

class Person3{
    private String name;
    private int age;
    public Person3(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return name + "======" + age;
    }
}



