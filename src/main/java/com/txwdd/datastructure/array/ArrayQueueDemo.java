package com.txwdd.datastructure.array;

/**
 * 使用数组模拟队列
 * 先进先出
 *
 * 问题：
 *  只能使用一次，不能复用
 *  优化：
 *  改进成环形的数组，核心 取模
 */
public class ArrayQueueDemo {


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(4);
        arrayQueue.show();


        try {
            System.out.println(arrayQueue.getQueue());
            System.out.println(arrayQueue.getQueue());
            System.out.println(arrayQueue.getQueue());
            System.out.println(arrayQueue.getQueue());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        arrayQueue.addQueue(5);
        arrayQueue.show();

    }


}

class ArrayQueue {

    public int maxSize;//队列最大容量
    public int front;  //队头指针 指向队列头部，指向队列头的前一个位置
    public int real; //队尾指针 指向队列尾部，指向队列尾的数据 即队列最后一个数据
    public int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        real = -1;
    }

    //判断队列是否已满 数组下标从0开始 最大index==maxSize-1
    public boolean isFull() {
        return real == maxSize - 1;
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
        real++;
        arr[real] = data;
    }

    //取出数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    public void show(){
        if(isEmpty()){
            System.out.println("队列为空，不打印");
            return;
        }
        for(int a=0;a<arr.length;a++){
            System.out.printf("array[%d]=%d\t\n",a,arr[a]);
        }
    }


}
