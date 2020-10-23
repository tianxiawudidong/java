package com.txwdd.lettcode.array;

import java.util.Arrays;

/**
 * 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 */
public class NumShow {

    public static void main(String[] args) {

        int[] arr={2,2,4,5,6,6,7,7};
        int[] ints = numShowOne(arr);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] numShowOne(int[] arr){
        int res=0;
        for(int a:arr){
            res^=a;
        }
        int num=res&(-res);
        int[] result=new int[2];
        for(int i=0;i<arr.length;i++){
            if((arr[i] & num) ==0){
                result[0]^=arr[i];
            }else{
                result[1]^=arr[i];
            }
        }
        return result;
    }


}
