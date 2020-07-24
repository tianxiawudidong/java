package com.txwdd.datastructure.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 思想：
 * 1、将一个无序数组 -》大顶堆
 * 2、将数组头部元素与尾部元素交换，然后再将前n-1个元素继续构造成大顶推 依此
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};

        heapSort(arr);

        System.out.println("推排序后数组为:" + Arrays.toString(arr));
    }


    private static void heapSort(int[] arr) {
        int temp=0;
//        constructHeap(arr, 1, arr.length);
//        System.out.println("第一次推排序后数组为:" + Arrays.toString(arr)); // 4 9 8 5 6
//        constructHeap(arr, 0, arr.length);
//        System.out.println("第2次推排序后数组为:" + Arrays.toString(arr)); // 9 6 8 5 4

        //一颗顺序二叉树的非叶子节点的个数为： arr.length/2-1

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            constructHeap(arr, i, arr.length);
        }


        //交换数据
        for (int j = arr.length - 1; j >0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            constructHeap(arr, 0, j);
        }


    }


    /**
     * 将无序队列构造成大顶堆
     *
     * @param arr    数组
     * @param i      非叶子节点的在数组中的索引
     * @param length 数组长度
     */
    private static void constructHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (temp < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

}
