package com.cn.prc_1;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args){
        System.out.println("hello\nworld");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch(i){
            case 0:{
                System.out.println(0);
                break;
            }
            case 1:{
                System.out.println(1);
                break;
            }
            case 2:{
                System.out.println(2);
                break;
            }
            default:{
                System.out.println("----");
            }
        }
    }
}
