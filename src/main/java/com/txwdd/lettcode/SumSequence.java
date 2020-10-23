package com.txwdd.lettcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  和为s的连续正数序列
 *  输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 *
 * 限制：
 *
 *     1 <= target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumSequence {


    public static void main(String[] args) {
        int[][] ints = sumSequence(19);
        int[][] ints2 = sumSequence(91);
        for(int i=0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }

    }

    /**
     * 使用滑动窗口解决 [start,end)
     *
     *  9
     *  1 2 3 4 5 6 7 8 9 10...
     */
    private static int[][] sumSequence(int target){
        int i=1; //start
        int j=1; //end
        int sum=0;
        List<int[]> list=new ArrayList<>();
        while (i<=target/2){
            if(sum<target){
                //右指针向右移动
                sum+=j;
                j++;
            }else if(sum>target){
                 //左指針右移
                sum-=i;
                i++;
            }else{ //sum ==target
                int[] arr=new int[j-i];
                for(int k=i;k<j;k++){
                    arr[k-i]=k;
                }
                list.add(arr);
                sum-=i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }


}
