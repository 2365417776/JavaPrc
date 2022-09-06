package com.cn.prc_2;

public class Wrapping {
    public static void main(String[] args) {
        //创建一个包装类
        Int a = new Int(12); //装箱操作
        int b = a.getValue(); //折箱操作
        Integer c = new Integer(34); //手动装箱（已过期）
        int d = c.intValue(); //手动折箱
        //自动装箱与折箱
        Integer f = 245;
        int g = f;
        //基本数据转换（字符串转换为相应数据类型）
        String str1 = "1234";
        int num1 = Integer.parseInt(str1);
        System.out.println(num1 * 2);
    }
}

//定义包装类
class Int{
    private int value;
    public Int(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
