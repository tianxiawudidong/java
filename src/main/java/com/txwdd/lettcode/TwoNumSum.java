package com.txwdd.lettcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * {1,3,5,2,6}  11
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumSum {


    public static void main(String[] args) {
        int[] arr={1,3,5,2,6};
        int target=11;
        try {
            int[] ints = towNumSum(arr, target);
            System.out.println("result==="+ Arrays.toString(ints));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static int[] towNumSum(int[] arr, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int res = target - arr[i];
            if (map.containsKey(res)) {
                return new int[]{map.get(res), i};
            }
            //1-->0
            //3-->1
            //5-->3
            //2-->4
            map.put(arr[i], i);
        }
        throw new RuntimeException("not found");
    }
}
