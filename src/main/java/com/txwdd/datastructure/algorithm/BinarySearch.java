package com.txwdd.datastructure.algorithm;

/**
 * 二分查找 非递归
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 8, 10};
        int i = binarySearch(arr, 3);
        System.out.println(i);

        int i2 = binarySearch2(arr, 0, arr.length - 1, 3);
        System.out.println(i2);
    }

    /**
     * 二分查找 非递归
     *
     * @param arr
     * @param val
     * @return
     */
    private static int binarySearch(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] < val) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }
        return -1;
    }

    private static int binarySearch2(int[] arr, int left, int right, int val) {
        int mid = (left + right) / 2;
        if (arr[mid] == val) {
            return mid;
        } else if (arr[mid] < val) {
            return binarySearch2(arr, mid + 1, right, val);
        } else {
            return binarySearch2(arr, left, mid - 1, val);
        }
    }
}
