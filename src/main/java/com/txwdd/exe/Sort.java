package com.txwdd.exe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 数据结构 排序算法
 */
public class Sort {

    private static final Logger LOG = LoggerFactory.getLogger(Sort.class);

    public static void main(String[] args) {
        int[] arr = {3, 10, 9, 5, 8, 1, 6, 4, 7};
        LOG.info("排序前:{}", Arrays.toString(arr));
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        shellSort(arr);
//        shellSort2(arr);
        myQuickSort(arr, 0, arr.length - 1);
        LOG.info("排序后:{}", Arrays.toString(arr));
    }


    /**
     * 冒泡排序 时间复杂度 O(n^2)
     * {2, 1, 9, 3, 5, 4, 6, 8, 7};
     * 第一轮：1  2  3  5 4 6 8 7 9
     * 第二轮: 1  2  3  4 5 6 7 8 9
     * 一共进行n-1轮排序
     * 每一轮排序比较、交换相邻两个元素的位置，知道最大的数落在最后的位置
     */
    private static void bubbleSort(int[] arr) {
        long start = System.currentTimeMillis();
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag) { //如果本轮排序没有发生交换，则退出本轮排序
                break;
            } else {
                flag = false;//重置flag
            }
            LOG.info("第{}轮 :{}", i + 1, Arrays.toString(arr));
        }
        long end = System.currentTimeMillis();
        LOG.info("bubble sort use time：{}", (end - start));
    }

    /**
     * 选择排序 时间复杂度 O(n^2)
     * {2, 1, 9, 3, 5, 4, 6, 8, 7};  {3, 4, 9, 2, 5, 1, 6, 8, 7};
     * 第一轮:1 2 9 3 5 4 6 8 7       1  4  9 2 5 3 6 8 7
     * 第二轮:1 2 9 3 5 4 6 8 7       1  2 9 4 5 3 6 8 7
     * 第三轮:1 2 3 9 5 4 6 8 7       1  2 3 4 5 9 6 8 7
     * 第四轮:1 2 3 4 5 9 6 8 7       1  2 3 4 5 9 6 8 7
     * 第五轮:1 2 3 4 5 9 6 8 7        1  2 3 4 5 9 6 8 7
     * 第六轮:1 2 3 4 5 6 9 8 7         1  2 3 4 5 6 9 8 7
     * 第七轮:1 2 3 4 5 6 7 8 9        1  2 3 4 5 6 7 8 9
     * 第八轮:1 2 3 4 5 6 7 8 9        1  2 3 4 5 6 7 8 9
     * 一共进行n-1轮排序
     * 每一轮排序把第n小的数和n位置的数进行交换
     */
    private static void selectSort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            LOG.info("第{}轮 :{}", i + 1, Arrays.toString(arr));
        }
        long end = System.currentTimeMillis();
        LOG.info("select sort use time：{}", (end - start));
    }

    /**
     * 插入排序 时间复杂度 O(nlogN)
     * {3, 4, 9, 2, 5, 1, 6, 8, 7};
     * 把数组分成两部分 {3} {4,9,2,5,1,6,8,7};
     * <p>
     * 从后面数组开始每次取第一个元素加入到第一部分中
     */
    private static void insertSort(int[] arr) {

        //待插入的数
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
            System.out.println("第" + i + "轮排序后:" + Arrays.toString(arr));
        }

    }


    /**
     * 希尔排序 --插入排序的一种改进，移动次数过多
     * 也叫缩小增量排序 分组gap+交换+插入排序
     * {3, 4, 9, 2, 5, 1, 6, 8, 7};
     * <p>
     * 分组：length/2
     * 第一次 5组       每组size/group 2个元素 比较并交换 小的数放前面
     * 第二次 5/2 两组  每组           5个元素 比较并交换
     * 第三次 2/2 1组 两种方式 交换法、位移法
     */
    private static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {      // 5 6 7 8 9
                for (int j = i - gap; j >= 0; j -= gap) { //0 1 2 3 4
                    int temp;
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

     /*   int gap = arr.length / 2; // 4
        for (int i = gap; i < arr.length; i++) {      // 4 5 6 7 8
            for (int j = i - gap; j >= 0; j -= gap) { //0 1 2 3 4
                int temp;
                if (arr[j] > arr[j + gap]) {
                    temp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = temp;
                }
            }
        }
        LOG.info("第一次后:{}", Arrays.toString(arr));

        gap = gap / 2;
        for (int i = gap; i < arr.length; i++) {      // 4 5 6 7 8
            for (int j = i - gap; j >= 0; j -= gap) { //0 1 2 3 4
                int temp;
                if (arr[j] > arr[j + gap]) {
                    temp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = temp;
                }
            }
        }
        LOG.info("第二次后:{}", Arrays.toString(arr));

        gap = gap / 2;
        for (int i = gap; i < arr.length; i++) {      // 4 5 6 7 8
            for (int j = i - gap; j >= 0; j -= gap) { //0 1 2 3 4
                int temp;
                if (arr[j] > arr[j + gap]) {
                    temp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = temp;
                }
            }
        }
        LOG.info("第三次后:{}", Arrays.toString(arr));*/
    }

    /**
     * 希尔排序  位移法 --插入排序的一种改进，移动次数过多
     * 也叫缩小增量排序 分组gap+交换+插入排序
     * {3, 4, 9, 2, 5, 1, 6, 8, 7};
     * <p>
     * 分组：length/2
     * 第一次 5组       每组size/group 2个元素 比较并交换 小的数放前面
     * 第二次 5/2 两组  每组           5个元素 比较并交换
     * 第三次 2/2 1组 两种方式 交换法、位移法
     */
    private static void shellSort2(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }


    /**
     * 快速排序
     * ：冒泡排序的一种改进
     * 1、选择一个数作为基准值，使得左边所有数都比基准值小，右边所有值比基准值大
     * 2、对左边数据递归，对右边数据递归
     */
    private static void myQuickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //基准值
        int privot = arr[(left + right) / 2];
        int temp;
        while (l < r) {

            //遍历左边 直到找到一个比基准值大的值
            while (arr[l] < privot) {
                l += 1;
            }
            //遍历右边 直到找到一个比基准值小的值
            while (arr[r] > privot) {
                r -= 1;
            }

            if(l>=r){
                break;
            }

            //交换
            temp=arr[r];
            arr[r]=arr[l];
            arr[l]=temp;

            if(arr[l]==privot){
                r-=1;
            }
            if(arr[r]==privot){
                l+=1;
            }
        }



        if(l==r){
            l+=1;
            r-=1;
        }

        //左递归
        if(left<r){
            myQuickSort(arr,left,r);
        }
        //右递归
        if(l<right){
            myQuickSort(arr,l,right);
        }

    }


}
