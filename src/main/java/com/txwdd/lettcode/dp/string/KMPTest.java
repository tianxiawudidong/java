package com.txwdd.lettcode.dp.string;

import java.util.Arrays;

public class KMPTest {


    public static void main(String[] args) {

        String str1="BBC ABCDAB ABCDABCDABDE";
        String str2="ABCDABD";

        int[] arr = kmpNext(str2);
        System.out.println(Arrays.toString(arr));

        int i = kmpMatch(str1, str2, arr);
        System.out.println(i);
    }


    /**
     * 字符串匹配 ---暴力匹配
     */
    private static int strMatch1(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len=s1.length;
        int s2Len=s2.length;

        int i=0,j=0;

        while (i<s1Len && j<s2Len){

            if(s1[i]==s2[j]){
                i++;
                j++;
            }else{
                i=i-(j-1);
                j=0;
            }
        }
        if(j==s2Len){
            return i-j;
        }else{
            return -1;
        }

    }


    /**
     * 计算部分匹配表的值
     */
    private static int[] kmpNext(String str){
        int[] next=new int[str.length()];
        next[0]=0;
        for(int i=1,j=0;i<str.length();i++){
            while (j>0 && str.charAt(i) != str.charAt(j)){
                  j=next[j-1];
            }
            if(str.charAt(i)==str.charAt(j)){
                  j++;
            }
            next[i]=j;
        }
        return next;
    }

    /**
     * kmp算法
     */
    private static int kmpMatch(String str1,String str2,int[] next){
        for(int i=0,j=0;i<str1.length();i++){

            while (j>0 && str1.charAt(i) != str2.charAt(j)){
                j=next[j-1];
            }
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

}
