package com.txwdd.lettcode;

/**
 * 最长回文子串
 * 回文的意思是  正着念和倒着念一样，如：上海自来水来自海上
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongString {

    public static void main(String[] args) {
        String str = "cbbd";
        String s = longString(str);
        System.out.println(s);
    }

    private static String longString(String s) {
        if (s == null || s.length() == 0) return s;
        int len = s.length();
        int max = 1, start = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for(int j=1;j<len;j++){
            for(int i=0;i<j && i<len-1;i++){
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j]=false;
                }else{
                    if(j-i<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j-i+1>max){
                    max=j-i+1;
                    start=i;
                }
            }
        }
        return s.substring(start,start+max);
    }

}
