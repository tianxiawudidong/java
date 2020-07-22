package com.txwdd.datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 栈-- 逆波兰表达式
 */
public class PolandNation {


    public static void main(String[] args) {
        //4*5-8+60+8/2  ==> 4 5 * 8 - 60 8 2 / +
        //(3+4)*5-6
//        String suffixExpression = "3 4 + 5 * 6 -";
        //思路
        //1、先将表达式---》放入list中
        //2、将list 传递给一个方法 遍历list  配合栈 完成计算
//        List<String> list = getListString(suffixExpression);
//        calculate(list);

        //完成一个将中缀表达式转成后缀表达式得功能
        //说明
        //1、1+((2+3)*4)-5  ==>转成 1 2 3 + 4 * + 5 -
        //2、因为直接对str进行操作不方便，因此先将中缀表达式放入list中
        //即  1+((2+3)*4)-5 =》[1,+,(,(,2,+,3,),*,4,-,5]
        //3、将得到得中缀表达式list =》后缀表达式对应得list

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应得list===" + infixExpressionList);

        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应得list==="+suffixExpressionList);
        calculate(suffixExpressionList);
    }

    /**
     * 将中缀表达式对应的list 转成后缀表达式对应的list
     * 步骤：
     * 1、初始化两个栈：运算符栈s1和储存中间结果的栈s2；
     * 2、从左至右扫描中缀表达式；
     * 3、遇到操作数时，将其压s2；
     * 4、遇到运算符时，比较其与s1栈顶运算符的优先级：
     * 4.1、如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     * 4.2、否则(s1不为空)，比较优先级
     *  若优先级比栈顶运算符的高，也将运算符压入s1；
     * 4.3、否则（优先级低于栈顶元素），将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较；
     * 5、遇到括号时：
     * (1) 如果是左括号“(”，则直接压入s1
     * (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，
     * 直到遇到左括号为止，此时将这一对括号丢弃
     * 6、重复步骤2至5，直到表达式的最右边
     * 7、将s1中剩余的运算符依次弹出并压入s2
     * 8、依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     */
    private static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<>(); //符号栈
        //说明：因为s2这个栈，在整个转换过程中，没有pop操作，而且后面我们需要逆序输出
        //因此比较麻烦，这里我们就不用Stack，直接用list
//        Stack<String> s2 = new Stack<>();
        List<String> s2 = new ArrayList<>(); //存储中间结果

        for (String item : ls) {
            //如果是一个数字，加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，
                //     *  直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); //！！！將( 彈出s1栈 消除小括号
            } else {
                //缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }

        //将s1栈中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;

    }

    //将表达式 切分 放入list中
    private static List<String> toInfixExpressionList(String expression) {
        List<String> list = new ArrayList<>();
        int i = 0;
        String str;//对多位数得拼接
        char c;
        do {
            //如果c是一个非数字 则直接加入list中
            if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else { //如果是一个数字，需要考虑多位数
                str = "";
                while (i < expression.length()
                    && (c = expression.charAt(i)) >= 48
                    && (c = expression.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }

        } while (i < expression.length());

        return list;
    }

    private static List<String> getListString(String expression) {
        List<String> list = new ArrayList<>();
        String[] split = expression.split(" ");
        if (split.length > 0) {
            list.addAll(Arrays.asList(split));
        }
        return list;
    }

    /**
     * 完成逆波兰表达式的运算
     * 3 4 + 5 * 6 -
     * 1、从左至右扫描，将3 和4 压入栈中
     * 2、遇到+运算付，栈弹出 4 3 计算 3+4 的值 得7  再将7压入栈
     * 3、将5 入栈
     * 4、接下来是*运算符 因此弹出5 7 计算7 * 5=35 将35入栈
     * 5、将6入栈
     * 6、最后是-运算符，计算35-6 ===29 即最终结果
     */
    private static int calculate(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.matches("\\d")) {
                stack.push(Integer.parseInt(str));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (str) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                }
                stack.push(result);
            }
        }

        Integer pop = stack.pop();
        System.out.println("result===" + pop);
        return pop;
    }
}

//编写一个类Operation 可以返回一个运算符 对应的优先级
class Operation {

    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String oper) {
        int result = 0;
        switch (oper) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
        }
        return result;
    }

}
