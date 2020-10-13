package com.txwdd.lettcode;

import java.util.Arrays;

/**
 * 两个有序数组合并
 */
public class TwoArrCompact {

    private static int[] merge(int[] a, int b[]) {

        int[] result = new int[a.length + b.length];
        //i: a数组 j:b数组 k:result数组
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i];
                i++;
            } else {
                result[k++] = b[j];
                j++;
            }
        }
        /* 后面连个while循环是用来保证两个数组比较完之后剩下的一个数组里的元素能顺利传入 */
        while (i < a.length) {
            result[k++] = a[i++];
        }
        while (j < b.length) {
            result[k++] = b[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6};
        int[]b={3,4,5,6,7,8,9,10};
        int[] c = merge(a, b);
        System.out.println(Arrays.toString(c));
    }
}
