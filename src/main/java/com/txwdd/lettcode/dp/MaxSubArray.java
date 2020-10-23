package com.txwdd.lettcode.dp;

/**
 * 最大子序和
 */
public class MaxSubArray {


    public static void main(String[] args) {

        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        //         -2 1 -2 4  3 5 6 1 5
        int res = maxSubArray(arr);
        System.out.println(res);

    }

    private static int maxSubArray(int[] arr){
        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            dp[i]=Math.max(arr[i],arr[i]+dp[i-1]);
        }
        int max=dp[0];
        for(int val:dp){
            max=Math.max(val,max);
        }
        return max;
    }
}
