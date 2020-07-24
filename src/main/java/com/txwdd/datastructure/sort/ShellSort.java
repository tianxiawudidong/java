package com.txwdd.datastructure.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 希尔（Donald Shell）于1959年提出的一种排序算法。
 * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序。
 * <p>
 * 思想：
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
 */
public class ShellSort {


    public static void main(String[] args) {

//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
//        System.out.println("原始数组为：" + Arrays.toString(arr));
//        shellSort(arr);
        shellSort2(arr);
//        System.out.println("希尔排序后数组为：" + Arrays.toString(arr));
    }


    /**
     * 希尔排序 交换法
     * {8,9,1,7,2,  3,5,4,6,0};
     * 3 5 1 6 0   8 9 4 7 2
     */
    private static void shellSort(int[] arr) {

        //第一轮排序
        //分组  size/2 ==>  5
        long start = System.currentTimeMillis();
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素(共5组 每组2个元素，) 步长5
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素 大于加上步长后的那个元素  说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //3 5 1 6 0  8 9 4 7 2
//            System.out.println("希尔排序1轮后=" + Arrays.toString(arr));
        }
        long end = System.currentTimeMillis();
        System.out.println("use time:" + (end - start));


        /*
        int temp;
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有的元素(共5组 每组2个元素，) 步长5
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素 大于加上步长后的那个元素  说明交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        //3 5 1 6 0  8 9 4 7 2
        System.out.println("希尔排序1轮后=" + Arrays.toString(arr));

        //第二轮希尔排序
        //gap=5/2=2
        //3, 5, 1, 6, 0, 8, 9, 4, 7, 2
        //排序结果:
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中所有的元素(共5组 每组2个元素，) 步长5
            for (int j = i - 2; j >= 0; j -= 2) {
                //如果当前元素 大于加上步长后的那个元素  说明交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序2轮后=" + Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            //遍历各组中所有的元素(共1组 每组10个元素，) 步长1
            for (int j = i - 1; j >= 0; j -= 1) {
                //如果当前元素 大于加上步长后的那个元素  说明交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序3轮后=" + Arrays.toString(arr));
    */

    }

    /**
     * 希尔排序 位移法（直接插入）
     */
    private static void shellSort2(int[] arr) {

        //第一轮排序
        //分组  size/2 ==>  5
        long start = System.currentTimeMillis();
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int j=i;
                temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0 && temp<arr[j-gap]){
                        //移动
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("use time:" + (end - start));
    }


}
