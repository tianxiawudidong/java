package com.txwdd.datastructure.sort;

import java.util.Arrays;

/**
 * 选择排序 思想:
 * 第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
 * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
 * 第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，
 * …，
 * 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，
 * …,
 * 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，
 * 总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
 */
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
            for (int j = i + 1; j < arr.length; j++) {
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
