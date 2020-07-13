package com.txwdd.datastructure.sparserray;

/**
 * 稀疏数组
 * 使用场景：棋盘存档、续上盘
 */
public class SparseArray {


    public static void main(String[] args) {
        int[][] array = new int[11][11];
        //0:没有棋子 1：表示黑棋  2：表示蓝棋
        array[1][2] = 1;
        array[2][3] = 2;
        array[3][3] = 2;
        array[4][5] = 1;

        print(array);

        /**
         * 将二位数组转成稀疏数组
         */
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    sum += 1;
                }
            }
        }
        System.out.println("原始数组有效数据个数:" + sum);

        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;
        int count=1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=array[i][j];
                    count++;
                }
            }
        }
        print(sparseArray);

        /**
         * 将稀疏数组转成原始数组
         */
        System.out.println("稀疏数组转原始数组:");
        int[][] arr2=new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i=1;i<sparseArray.length;i++){
            arr2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        print(arr2);

    }


    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }

}
