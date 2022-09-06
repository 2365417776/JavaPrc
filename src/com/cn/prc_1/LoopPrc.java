package com.cn.prc_1;
// 循环练习
public class LoopPrc {
    public static void main(String[] args) {
//        printMul();
//        printStar();
        printArr();
        int[] arr =  new int[5];
        System.out.println(arr[0]);
        modifyArr(arr);
        System.out.println(arr[0]);
    }

    /**
     * 打印九九乘法表
     */
    public static void printMul(){
        int i = 1,j;
        while(i < 10){
            j = 1;
            while(j <= i){
                System.out.print(j + "*" + i + "=" + i * j+"\t");
                j++;
            }
            System.out.println("");
            i++;
        }
    }

    /**
     * 打印星阵
     */
    public static void printStar(){
        for(int i = 0; i < 5; i++){
            for (int k = 5;k > i; k--)
                System.out.print(" ");
            for (int j = 0; j <= i; j++)
                System.out.print("* ");
            System.out.println("");
        }
    }

    /**
     * 遍历数组
     */
    public static void printArr(){
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        for (int temp: arr) {
            System.out.print(temp + " ");
        }
        System.out.println();
        int[] arr2 = {11, 22, 33, 44, 55, 66, 77, 88};
        for (int j = 0; j <arr2.length; j++){
            System.out.print(arr2[j] + " ");
        }
    }
    public static void modifyArr(int[] arr){
        arr[0] = 10;
    }
}
