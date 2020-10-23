package com.txwdd.lettcode.array;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AdjustArraySeq {

    public static void main(String[] args) {
         int[] arr={1,2,3,4};
        int[] ints = adjustArray(arr);
        System.out.println(Arrays.toString(ints));
        System.out.println(2&1);
    }

    private static int[] adjustArray(int[] arr){
        int i=0;
        int j=arr.length-1;
        int temp;
        while (i<j){
            while (i<j && arr[i] %2!=0) i++;
            while (i<j && arr[j] %2==0) j--;
            //交换
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        return arr;
    }


}
