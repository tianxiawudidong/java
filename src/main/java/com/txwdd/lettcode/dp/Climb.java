package com.txwdd.lettcode.dp;

/**
 * 爬楼梯问题
 * 斐波拉契数列 F(1)=0，F(2)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Climb {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long res1 = climb2(10);
        long end = System.currentTimeMillis();
        System.out.println(res1+"--->use time:"+(end-start));


        long start1 = System.currentTimeMillis();
        long res2 = climb3(10);
        long end1 = System.currentTimeMillis();
        System.out.println(res2+"--->use time:"+(end1-start1));


    }

    /**
     * 递归方式
     */
    private static long climb1(long n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climb1(n - 1) + climb1(n - 2);
        }
    }

    private static long climb2(long n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            long a = 1;
            long b = 2;
            long temp = 0;
            for (long i = 3; i <= n; i++) {
                temp = a + b;
                a = b;
                b = temp;
            }
            return temp;
        }
    }

    private static int climb3(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int[] arr=new int[n];
            arr[0]=1;
            arr[1]=2;
            for (int i = 2; i <n; i++) {
                arr[i]=arr[i-1]+arr[i-2];
            }
            return arr[n-1];
        }
    }

}
