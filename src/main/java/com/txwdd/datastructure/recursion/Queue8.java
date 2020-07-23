package com.txwdd.datastructure.recursion;

public class Queue8 {

    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array 保存皇后存放位置的结果 比如 arr={0,4,7,5,2,6,1,3}
    int[] array = new int[max];

    //判断总次数
    static int judgeCount=0;

    //解法
    static int count=0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法\n",count);
        System.out.printf("一共判断冲突的次数：%d\n",judgeCount);

    }

    private void check(int n) {
        if (n == max) { //n=8 其实8个皇后已经放好
            print();
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n 放到改行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时 是否冲突
            if (judge(n)) { //不冲突
                //接着放n+1个皇后，即开始递归
                check(n + 1);
            }
            //如果冲突，就继续执行array[n]=i;即将皇后放到改行的下一列
        }
    }


    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后是否冲突

    /**
     * @param n 表示第n个皇后
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //说明
            //1、array[i]== array[n] 表示判断 第nge皇后是否和前面的n-1个皇后是否在同一列
            //2、Math.abs(n-i)==Math.abs(array[n]-array[i]) 表示判断第n个皇后是否和第i个皇后在同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
