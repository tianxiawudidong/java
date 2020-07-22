package com.txwdd.datastructure.stack;

/**
 * 使用栈 模拟 计算器(中缀表达式)
 */
public class Calcutor {

    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4"; //18
        //创建两个栈，一个保存数值  一个保存操作符
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch;
        String keepNum = ""; //用于拼接 多位数
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOperator(ch)) {
                //判断当前符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较
                    //1、如果当前操作符的优先级小于或等于栈中的操作符，就需要从数栈中pop出两个数
                    //从符号栈中pop出一个符号，进行计算 将得到的结果入数栈，然后将当前的操作付入符号栈

                    if (operStack.priority(ch) <= operStack.priority(operStack.peak())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把结果入数栈
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        //2、如果当前操作付的优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                } else {//符号栈为空，直接入符号栈
                    operStack.push(ch);
                }
            } else { //如果当前字符是数值，就直接入数栈
//                numStack.push(ch - 48);
                //有问题，如果是多位数不会拼接
                //分析
                //1、当处理多位数时，不能发现是一个数就立即入栈
                //2、在处理数，需要向表达式的index后再看一位，
                //  如果是数就继续往后扫描，直到下一位是符号才入数栈
                //3、因此我们需要定义一个变量字符串，用于拼接

                keepNum += ch;
                //如果ch已经是expression的最后一位，则直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入数栈
                    //注意看是后一位，不是index++
                    if (operStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //!! keepNum 清空
                        keepNum = "";
                    }
                }
            }
            //让index++,并判断是否扫描到expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }

        }

        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号 并运行
        while (true) {
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字  --- 结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        //将数栈中的数取出  就是结果
        int res2 = numStack.pop();
        System.out.printf("表达式 %s =%d", expression, res2);


    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
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

    //返回栈顶元素 不出栈
    public int peak() {
        return stack[top];
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

    //返回运算符的优先级 返回值越大优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '-' || oper == '+') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断当前字符是否为运算符
    public boolean isOperator(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;

    }
}



