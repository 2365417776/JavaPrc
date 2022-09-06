package com.cn.prc_3;

import org.junit.Test;

public class InternClass {
    @Test
    public void test01(){
        //访问内部类
        Outer.Inner inner = new Outer().new Inner();
        inner.print();
    }
    @Test
    public void test02(){
        //访问内部接口
        IOuter.IInter iInter = new OuterImpl().new InnerImpl();
        iInter.test02();
    }
    @Test
    public void test03(){
        //访问通内部类实现的接口，接口中定义了一个静态的获取子类对象的方法
        IInter iInter = IInter.getInstance();
        iInter.test();

    }
    @Test
    public void test04(){
        //访问静态内部类
        Outer03.Inner staticIner = new Outer03.Inner();
        staticIner.print();
    }
    @Test
    public void test05(){
        //访问静态接口
        IMessageWrap.send(new ChannelImpl(), new MessageImpl());
    }
    @Test
    public void test06(){
        //访问方法中的内部类
        Outer04 innerMethod = new Outer04();
        innerMethod.test(100);
    }
    @Test
    public void test07(){
        //匿名内部类
        new INoNameClass(){
            public void send(String msg){
                System.out.println(msg);
            }
        }.send("这是一个匿名内部类");
        //匿名内部类定义在了接口中
        INoNameClass2.getInstance().send("定义在接口中的匿名内部类");
    }
    @Test
    public void test08(){
        //使用lambda实现匿名内部类
        INoNameClass<String> noNameClass = (str) -> System.out.println(str);
        noNameClass.send("lambda表达式的实现");
        //使用方法引用实现匿名内部类
        INoNameClass<String> noNameClass2 = System.out::println;
        noNameClass2.send("lambda表达式的实现");
    }
}

//定义内部类
class Outer{
    private String msg = "Outer 类的定义";
    Inner inner = new Inner();
    public void getMark(){
        System.out.println("Outer类 ===" + inner.mark);
    }
    class Inner{
        private int mark = 404;
        public void print(){
            System.out.println("inner类 ===" + Outer.this.msg);
        }
    }
}
//定义内部接口
interface IOuter{
    public void test01();
    interface IInter{
        public void test02();
    }
}
//内部接口的实现
class OuterImpl implements IOuter{
    public void test01(){
        System.out.println("这是一个外部接口");
    }
    class InnerImpl implements IInter{
        public void test02(){
            System.out.println("这是一个内部接口");
        }
    }
}
//接口子类定义为自身内部类
interface IInter{
    public void test();
    class InterImpl implements IInter{
        public void test(){
            System.out.println("通过内部类实现外部接口");
        }
    }
    public static IInter getInstance(){
        return new InterImpl();
    }
}
//static定义内部类
class Outer03{
   static class Inner{
       public void print(){
           System.out.println("这是一个静态内部类");
       }
   }
}
//static定义内部接口
interface IMessageWrap{
    static interface IMessage{
        public void getContent();
    }
    static interface IChannel{
        public boolean connection();
    }

    public static void send(IChannel iChannel, IMessage iMessage){
        if(iChannel.connection())
            iMessage.getContent();
        else
            System.out.println("消息通道无法建立，消息发送失败");
    }
}
//实现static静态接口
class MessageImpl implements IMessageWrap.IMessage{
    @Override
    public void getContent(){
        System.out.println("消息通道建立，消息发送成功！");
    }
}
class ChannelImpl implements IMessageWrap.IChannel{
    @Override
    public boolean connection(){
        return true;
    }
}
//方法中定义内部类
class Outer04{
    private String msg = "方法中定义内部类";
    public void test(int num){
        //方法中定义内部类
        class InnerMethod{
            public void test02(){
                System.out.println(Outer04.this.msg);
                //方法内部类中访问方法上的参数
                System.out.println(num);
            }
        }
        //直接调用方法中的内部类
        new InnerMethod().test02();
    }
}
//匿名内部类
@FunctionalInterface //这个注解表示此接口只能有一个方法（用于匿名内部类或lambda表达式）
interface INoNameClass<T extends String>{
    public void send(T msg);
}
//匿名内部类直接定义在接口中
interface INoNameClass2{
    public void send(String msg);
    public static INoNameClass2 getInstance(){
        return new INoNameClass2() {
            @Override
            public void send(String msg) {
                System.out.println(msg);
            }
        };
    }
}
//lambda表达式
