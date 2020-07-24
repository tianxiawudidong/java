package com.txwdd.datastructure.sort;

import java.util.Arrays;

/**
 * 插入排序 思想:
 * 把n个待排序的元素看成为一个有序表和一个无序表，
 * 开始时有序表中只包含一个元素，无序表中包含有n-1个元素，
 * 排序过程中每次从无序表中取出第一个元素，
 * 把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表
 */
public class InsertSort {


    public static void main(String[] args) {

        int[] arr = {101, 54, 51, 1};
        System.out.println("原始数组为:");
        System.out.println(Arrays.toString(arr));

        insertSort(arr);
        System.out.println("排序后数组为:");
        System.out.println(Arrays.toString(arr));

        /**
         //第一轮
         //{101,54,51,1} ==> {54,101,51,1}

         //定义待插入的数
         int insertVal = arr[1]; //54
         int insertIndex = 1 - 1;//即arr[1] 前面一个数的下标
         //给insertVal找到合适的位置
         //说明：
         //1、insertIndex>=0  保证在给insertVal找插入位置 不越界
         //2、insertVal <arr[insertIndex] 待插入的数，还没有找到插入位置
         //3、就需要将arr[insertIndex]后移
         //0  && 54 <101
         while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
         //{101,101,51,1}
         arr[insertIndex + 1] = arr[insertIndex];
         //-1
         insertIndex--;
         }

         //当退出while循环时，说明插入的位置找到，insertIndex+1
         //{54,101,51,1}
         arr[insertIndex + 1] = insertVal;
         System.out.println("第1伦插入");
         System.out.println(Arrays.toString(arr));

         //第二轮 {54,101,51,1}
         insertVal = arr[2]; //51
         insertIndex = 2 - 1;//即arr[2] 前面一个数的下标
         //1 && 51 <101
         //0 && 51<arr[0] 54
         while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
         //{54,101,101,1}
         //{54,54,101,1}
         arr[insertIndex + 1] = arr[insertIndex];
         //0
         //-1
         insertIndex--;
         }
         //arr[0]=51
         //{51,54,101,1}
         arr[insertIndex + 1] = insertVal;
         System.out.println("第2伦插入");
         System.out.println(Arrays.toString(arr));

         //第三轮
         insertVal = arr[3];
         insertIndex = 3 - 1;
         while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
         arr[insertIndex + 1] = arr[insertIndex];
         insertIndex--;
         }
         arr[insertIndex + 1] = insertVal;
         System.out.println("第3伦插入");
         System.out.println(Arrays.toString(arr));
         */

    }

    private static void insertSort(int[] arr) {
        int insertVal;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i]; //54
            insertIndex = i - 1;//即arr[1] 前面一个数的下标
            //给insertVal找到合适的位置
            //说明：
            //1、insertIndex>=0  保证在给insertVal找插入位置 不越界
            //2、insertVal <arr[insertIndex] 待插入的数，还没有找到插入位置
            //3、就需要将arr[insertIndex]后移
            //0  && 54 <101
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //{101,101,51,1}
                arr[insertIndex + 1] = arr[insertIndex];
                //-1
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
            System.out.printf("第%d伦插入", i);
            System.out.println(Arrays.toString(arr));
        }

    }

}
