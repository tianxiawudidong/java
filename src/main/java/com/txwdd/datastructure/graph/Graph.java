package com.txwdd.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 图
 */
public class Graph {

    //存放顶点的集合
    private List<String> vertexList;
    //存放数据
    private int[][] edges;
    //边的数量
    private int edgeCount;
    //标记是否被访问过 true 访问 false 未访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        //使用矩阵（二维数组）构建图
        int n = 5;  //结点的个数
        String vertexs[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }

        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1); //
        graph.insertEdge(1, 2, 1); //
        graph.insertEdge(1, 3, 1); //
        graph.insertEdge(1, 4, 1); //

        graph.showGraph();

//        System.out.println("深度遍历~~");
//        graph.dfs();

        System.out.println("广度遍历~~");
        graph.bfs();

    }

    //n 顶点的个数
    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        isVisited = new boolean[5];
    }

    //图中常用的方法
    //插入结点
    private void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //插入边（结点之间的关系） 无向

    /**
     * @param v1     表示点的下标即使第几个顶点  "A"-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight 表示 权值
     */
    private void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgeCount++;
    }

    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return edgeCount;
    }

    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
        //return edges[v2][v1];
    }

    //显示图
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
    //获取当前节点的第一个邻接节点 下标w

    /**
     * @param index 当前节点下标
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    //深度遍历
    //1、访问初始结点v，并标记结点v为已访问。
    //2、查找结点v的第一个邻接结点w。
    //3、若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续。
    //4、若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）。
    //5、查找结点v的w邻接结点的下一个邻接结点，转到步骤3。
    private void dfs(boolean[] isVisited, int i) {
        //首先我们访问该结点,输出
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1) {//说明有
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    public void dfs() {
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //广度遍历
    //图的广度优先搜索(Broad First Search) 。
    //类似于一个分层搜索的过程，广度优先遍历需要使用一个队列以保持访问过的结点的顺序，以便按这个顺序来访问这些结点的邻接结点
    /**
     * 广度优先遍历算法步骤
     * 1、访问初始结点v并标记结点v为已访问。
     * 2、结点v入队列
     * 3、当队列非空时，继续执行，否则算法结束。
     * 4、出队列，取得队头结点u。
     * 5、查找结点u的第一个邻接结点w。
     * 6、若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
     * 6.1 若结点w尚未被访问，则访问结点w并标记为已访问。
     * 6.2 结点w入队列
     * 6.3 查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。
     */
    //对一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited, int i) {
        int u ; // 表示队列的头结点对应下标
        int w ; // 邻接结点w
        //队列，记录结点访问的顺序
        LinkedList queue = new LinkedList();
        //访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);

        while( !queue.isEmpty()) {
            //取出队列的头结点下标
            u = (Integer)queue.removeFirst();
            //得到第一个邻接结点的下标 w
            w = getFirstNeighbor(u);
            while(w != -1) {//找到
                //是否访问过
                if(!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻结点
                w = getNextNeighbor(u, w); //体现出我们的广度优先
            }
        }
    }

    //遍历所有的结点，都进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }


}



