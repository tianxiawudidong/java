package com.txwdd.lettcode;


import java.util.*;

/**
 * leetcode
 */
public class Test {

    public static void main(String[] args) {

        /**
         * 爬楼梯
         */
        /*int climb = climb(5);
        System.out.println(climb);*/

        /**
         *  快排
         */
     /* int[] arr = {4, 2, 1, 5, 6, 7, 9, 8, 10, 3};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
     */

        /**
         * 最长回文子串
         */
        /*String str = "cvvd";
        String s = longString(str);
        System.out.println(s);*/


        /**
         * 链表反转
         */
       /* Linked head = new Linked(1);
        head.next = new Linked(2);
        head.next.next = new Linked(3);
        head.next.next.next = new Linked(4);
        head.next.next.next.next = new Linked(5);
        print(head);
        System.out.println();
        Linked reverse = reverseLinked(head);
        print(reverse);*/

        /**
         * 数组topK问题
         */
        /*int[] arr = {4, 2, 1, 5, 6, 7, 9, 8, 10, 3};
        int k=5;
        System.out.println(topKInArray(arr,k));*/

        /**
         * 两数之和
         */
     /*   int[] arr = {4, 8, 3, 5};
        int target=11;
        int[] indexByTarget = findIndexByTarget(arr, target);
        System.out.println(Arrays.toString(indexByTarget));*/

        /**
         * 判断符号是否有效
         */
        String str = "[{(})]";
        boolean valid = isValid(str);
        System.out.println(valid);
    }


    /**
     * 爬楼梯问题--动态规划
     */
    private static int climb(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            int temp = 0;
            int a = 1;
            int b = 2;
            for (int i = 3; i <= n; i++) {
                temp = a + b;
                a = b;
                b = temp;
            }
            return temp;
        }
    }

    /**
     * 快排
     */
    private static void quickSort(int[] arr, int left, int right) {

        int l = left;
        int r = right;
        //基准值
        int mid = arr[(left + right) / 2];
        int temp;
        while (l <= r) {
            //遍历l--》mid 找到比mid大的值
            while (arr[l] < mid) {
                l += 1;
            }
            while (arr[r] > mid) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == mid) {
                r -= 1;
            }
            if (arr[r] == mid) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        if (l < right) {
            quickSort(arr, l, right);
        }

    }

    /**
     * 最长回文子串
     */
    private static String longString(String str) {
        if (str == null || str.length() == 0) return null;
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        char[] chars = str.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int max = 1, start = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < len && i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return str.substring(start, start + max);
    }



    /**
     * 未排序的数组中 取出第k大的数
     * 使用最小堆
     */
    private static int topKInArray(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : arr) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return null != queue.peek() ? queue.peek() : 0;
    }

    /**
     * 数组中找出两数之和为目标值的索引下标
     */
    private static int[] findIndexByTarget(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int res = target - arr[i];
            if (map.containsKey(res)) {
                return new int[]{map.get(res), i};
            }
            map.put(arr[i], i);
        }
        throw new RuntimeException("not found");
    }

    /**
     * 反转二叉树 -- 递归
     */
    private static TreeNode reverseTreeNode(TreeNode root) {
        if (root == null) return null;
        root.left = reverseTreeNode(root.right);
        root.right = reverseTreeNode(root.left);
        return root;
    }

    /**
     * 判断符号是否合法 --通过栈
     */
    private static boolean isValid(String str){
        Stack<Character> stack=new Stack<>();
        int len=str.length();
        for(int i=0;i<len;i++){
            char c = str.charAt(i);
            if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(c=='('){
                stack.push(')');
            }else{
                if(stack.isEmpty() || c != stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
