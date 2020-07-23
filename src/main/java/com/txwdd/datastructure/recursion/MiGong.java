package com.txwdd.datastructure.recursion;

/**
 * 递归 -- 迷宫问题
 */
public class MiGong {


    public static void main(String[] args) {
        //构造一个二维数组模拟迷宫
        int[][] map = new int[8][7];
        //使用1 表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        setWay(map,1,1);

        System.out.println("-------------------------");
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }


    /**
     * 使用递归回溯来给小球找路
     * 说明：
     * 1、map表示地图
     * 2、i，j 表示从地图的哪个位置开始出发 （1，1）
     * 3、如果小球能找到map[6][5]位置，则说明通路找到
     * 4、约定：当map[i][j]为0 表示该点没有走过
     *     为1 表示墙
     *     为2 表示通路可以走
     *     为3表示该点已经走过，但是走不通
     *
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j 从哪个位置开始找
     * @return 如果找到通路 就返回true，否则返回false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else{
            if(map[i][j]==0){ //如果当前这个点还没有走过
                //按照策略 下-》右-》上-》左 走
                map[i][j]=2; // 假定该点是可以走通
                if(setWay(map,i+1,j)){//向下走
                    return true;
                }else if(setWay(map,i,j+1)){//向右走
                    return true;
                }else if(setWay(map,i-1,j)){ //向上走
                    return true;
                }else if(setWay(map,i,j-1)){//向左走
                    return true;
                }else{
                    //说明该点走不通 是死路
                    map[i][j]=3;
                    return false;
                }
            }else{ //map[i][j]!=0 可能是 1 2 3
                return false;
            }
        }

    }
}
