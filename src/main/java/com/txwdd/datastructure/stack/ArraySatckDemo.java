package com.txwdd.datastructure.stack;

public class ArraySatckDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.list();

        int pop = arrayStack.pop();
        System.out.println(pop);
        int pop2 = arrayStack.pop();
        System.out.println(pop2);
        int pop3 = arrayStack.pop();
        System.out.println(pop3);
        int pop4 = arrayStack.pop();
        System.out.println(pop4);
        try {
            int pop5 = arrayStack.pop();
            System.out.println(pop5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }

        for (int i = top; i <= 0; i--) {
            System.out.printf("stack[%d] %d", i, stack[i]);
        }

    }


}
