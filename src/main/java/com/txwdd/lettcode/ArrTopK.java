package com.txwdd.lettcode;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrTopK {

    public static void main(String[] args) {
        int[] arr={3,2,3,1,2,4,5,5,6,7};  //1,2,2,3,3,4,5,5,6,7
        int k=4;

        int topK = findTopK(arr, k);
        System.out.println(topK);

    }

    //我们可以使用最小堆来解决，
    // 一个个遍历原数组的值，添加到堆中，如果堆中元素的个数小于等于k的时候，我们就往堆中添加，
    // 添加之后如果堆中元素个数大于k的时候，
    // 我们就把最顶端的元素给移除掉，
    // 因为是最小堆，所以移除的就是堆中最小的值
    public static int findTopK(int[] arr,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i:arr){
            queue.add(i);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}
