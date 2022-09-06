package com.cn.prc_1;

import java.nio.charset.StandardCharsets;

public class StringPrc {
    public static void main(String[] args) {
        //这是一个字符数组
        char[] ctr = new char[]{'c', 'h', 'i', 'n', 'a'};
        //使用String构造方法
        System.out.println(ctr);
        String str = new String(ctr);
        System.out.println(str.charAt(2));
        String str2 = "hello world";
        //字符串转为字符数组
        char[] ctr2 = str2.toCharArray();
        System.out.println(ctr2[2]);
        System.out.println("123456".getBytes()[0]);
    }
}

