package com.txwdd.datastructure.array;

/**
 * 使用环形数组 模拟队列
 * 解决：数组复用问题  核心：取模
 */
public class CircleArray {

    public static void main(String[] args) {
        ArrayQueue2 arrayQueue = new ArrayQueue2(5);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(4);
        arrayQueue.addQueue(5);
        arrayQueue.show();


        try {
            System.out.println(arrayQueue.getQueue());
            System.out.println(arrayQueue.getQueue());
            System.out.println(arrayQueue.getQueue());
            System.out.println(arrayQueue.getQueue());
            System.out.println(arrayQueue.getQueue());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}

class ArrayQueue2 {

    public int maxSize;//队列最大容量
    public int front;  //队头指针 front指向队列的第一个元素 初始值为0
    public int real; //队尾指针 real指向队列尾部的最后一个元素的后一个位置，即空出一个空间作为约定 初始值为0
    public int[] arr;

    public ArrayQueue2(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull() {
        return (real + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == real;
    }

    //添加数据到队列
    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
//        real++;
        arr[real] = data;
        real = (real + 1) % maxSize;
    }

    //取出数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
//        front++;
//        return arr[front];
        //这里需要分析出front指向的是队列的第一个元素
        int result = arr[front];
        front = (front + 1) % maxSize;
        return result;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空，不打印");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        for (int a = front; a < front + size(); a++) {
            System.out.printf("array[%d]=%d\t\n", a % maxSize, arr[a % maxSize]);
        }
    }

    //队列的有效元素的个数
    public int size() {
        return (real + maxSize - front) % maxSize;
    }


}
