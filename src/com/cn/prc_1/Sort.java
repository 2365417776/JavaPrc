package com.cn.prc_1;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {11, 44, 22, 55, 33, 99, 66, 5};
        int[] arr2 = {11, 22, 33, 44, 55, 66, 77};
//        selectSort(arr);
//        bubbleSort(arr);
//        reverseArr(arr2);
//        insertSort(arr);
//        shellSort(arr);
        quickSort(arr);
        printArr(arr);
        int result = binSearch(arr2, 100);
        System.out.println("\n" + result);
    }
    //冒泡排序（从小到大）
    public static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - 1 - i;j++){
                if(arr[j] > arr[j+1]){
                    arr[j] = arr[j] ^ arr[j+1];
                    arr[j+1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j] ^ arr[j+1];
                }
            }
        }
    }
    //选择排序（从大到小）
    public static void selectSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            int m = i;
            for(int j = i + 1;j < arr.length;j++){
                if(arr[m] < arr[j])
                    m = j;
            }
            if(m != i){
                //三个交换两个数的方法
//                int temp = arr[i];
//                arr[i] = arr[m];
//                arr[m] = temp;
//                arr[i] = arr[i] ^ arr[m];
//                arr[m] = arr[i] ^ arr[m];
//                arr[i] = arr[i] ^ arr[m];
                arr[i] = arr[i] + arr[m];
                arr[m] = arr[i] - arr[m];
                arr[i] = arr[i] - arr[m];
            }
        }
    }
    //插入排序法（从小到大）
    public static void insetSort(int[] arr){
        int i, j, temp;
        for(i = 1;i < arr.length;i++){
            if(arr[i] < arr[i-1]){
                temp = arr[i];
                for(j = i - 1; j >= 0 && arr[j] > temp;j--){
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;
            }
        }
    }
    public static void insertSort(int[] arr){
        int i, j, temp;
        for(i = 1;i < arr.length;i++){
            if(arr[i] < arr[i-1]){
                temp = arr[i];
                for(j = i - 1;j >= 0 && arr[j] > temp;j--){
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;
            }
        }
    }
    //希尔排序（从小到大）
    public static void shellSort(int[] arr){
        for(int n = arr.length / 2;n >= 1;n /= 2){
            int i, j,temp;
            for(i = n;i < arr.length;i++){
                if(arr[i] < arr[i-n]){
                    temp = arr[i];
                    for(j = i - n;j >= 0 && arr[j] > temp;j-=n){
                        arr[j + n] = arr[j];
                    }
                    arr[j + n] = temp;
                }
            }
        }
    }
    //快速排序（从小到大）
    public static void quickSort(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        quickSortMain(arr, low, high);
    }
    public static void quickSortMain(int[] arr, int low, int high){
        if(low < high){
            int pivot = partitionDivide(arr, low, high);
            //左半部分的划分
            quickSortMain(arr, low, pivot - 1);
            quickSortMain(arr, pivot + 1, high);
        }

    }
    // 这个方法用来划分数组为左小右大
    public static int partitionDivide(int[] arr, int low, int high){
        //设置一个用于存放数组首个元素的临时变量
        int pivot;
        pivot = arr[low];
        while(low < high){
            while(low < high && arr[high] > pivot) high--;
            arr[low] = arr[high];

            while(low < high && arr[low] < pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
    //数组转置
    public static void reverseArr(int[] arr){
        int head = 0;
        int tail = arr.length - 1;
       for(int i = 0;i < arr.length / 2;i++){
           arr[head] = arr[head] + arr[tail];
           arr[tail] = arr[head] - arr[tail];
           arr[head] = arr[head] - arr[tail];
           head++;
           tail--;
       }
    }
    //折半查找算法
    public static int binSearch(int[] arr, int target){
        int low, high, mid;
        low = 0;
        high = arr.length - 1;
        while(low <= high){
            mid = (low + high) / 2;
            if(target == arr[mid]){
                return mid;
            }
            if(target > arr[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void printArr(int[] arr){
        for(int value : arr){
            System.out.print(value + " ");
        }
    }
}
