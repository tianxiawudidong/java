package com.txwdd.datastructure.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 1, 6, 5};
        System.out.println("排序前:" + Arrays.toString(arr));

        selectSort(arr);
        System.out.println("排序后:" + Arrays.toString(arr));
    }


    /**
     * 选择排序 ：每i轮排序将第i小的数据 与下标为i的数据交换
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {


        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }

    }
}
