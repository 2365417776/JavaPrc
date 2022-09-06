package com.cn.prc_1;

public class methods_2 {
    public static void main(String[] args) {
        System.out.println(recursion(100));
        System.out.println(sum(3));
    }

    /**
     * @param num 进行累加的操作
     * @return 数据的计算结果
     */
    public static int recursion(int num){
        if(num == 1){
            return 1;
        }
        return num + recursion(--num);
    }

    public static int sum(int num){
        if(num == 1)
            return 1;
        else
            return factorial(num) + sum(--num);
    }
    /**
     * @param num 阶乘的每个数字
     * @return 阶乘的结果
     */
    public static int factorial(int num){
        if(num == 1)
            return 1;
        else
            return num * factorial(--num);
    }
}
