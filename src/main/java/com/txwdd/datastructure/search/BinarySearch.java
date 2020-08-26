package com.txwdd.datastructure.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 6, 12, 12, 12, 12,13,14, 22};

//        int i = binarySearch(arr, 0, arr.length - 1, -1);
//        System.out.println("index====" + i);

        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 12);
        System.out.println("list====" + list);

    }

    public static int binarySearch(int[] arr, int left, int right, int findValue) {

        //没有找到 退出条件，否则会死循环 栈溢出
        if (left > right) {
            return -1;
        }

        int midIndex = (left + right) / 2;
        int midValue = arr[midIndex];

        if (findValue > midValue) { //向右递归
            return binarySearch(arr, midIndex + 1, right, findValue);
        } else if (findValue < midValue) {
            return binarySearch(arr, left, midIndex - 1, findValue);
        } else {
            return midIndex;
        }

    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findValue) {

        //没有找到 退出条件，否则会死循环 栈溢出
        if (left > right) {
            return new ArrayList<>();
        }

        int midIndex = (left + right) / 2;
        int midValue = arr[midIndex];

        if (findValue > midValue) { //向右递归
            return binarySearch2(arr, midIndex + 1, right, findValue);
        } else if (findValue < midValue) {
            return binarySearch2(arr, left, midIndex - 1, findValue);
        } else {
//            return midIndex;
            List<Integer> list = new ArrayList<>();
            list.add(midIndex);
            //向左遍历
            int temp = midIndex - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findValue) {
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            //向右遍历
            temp = midIndex + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findValue) {
                    break;
                }
                list.add(temp);
                temp += 1;
            }
            return list;
        }

    }

}
