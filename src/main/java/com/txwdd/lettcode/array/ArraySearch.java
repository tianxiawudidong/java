package com.txwdd.lettcode.array;

/**
 * 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArraySearch {

    public static void main(String[] args) {

        System.out.println(7 & -7);

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
          //行
          int m=matrix.length;
          if(m==0) return false;
          //列
          int n=matrix[0].length;

          //最后一行第一列
          int i=m-1;
          int j=0;

          while (i>=0 && j<n){
              //比值大 说明在上面
              if(matrix[i][j]>target) i--;
              //比值小 说明在右面
              else if(matrix[i][j]<target) j++;
              else return true;
          }
          return false;

    }


}
