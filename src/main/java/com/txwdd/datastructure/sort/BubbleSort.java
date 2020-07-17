package com.txwdd.datastructure.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 6, 4};
        System.out.println("排序前:" + Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println("排序后:" + Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr) {

        boolean flag=false;
        for (int i = 0; i < arr.length - 1; i++) {
            int temp;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag=true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟后結果"+Arrays.toString(arr));
            if(!flag){
                break;
            }else{
                flag=false;
            }
        }

    }
}
