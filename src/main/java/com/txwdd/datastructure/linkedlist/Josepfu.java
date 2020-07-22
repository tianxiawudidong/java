package com.txwdd.datastructure.linkedlist;

/**
 * 约瑟夫问题 （丢手帕问题）
 */
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
//        circleSingleLinkedList.show();

        circleSingleLinkedList.countBoy(1,2,5);
    }
}

//创建环形单向链表
class CircleSingleLinkedList {

    private Boy first = null;

    //添加小孩到环形链表
    public void addBoy(int number) {
        if (number < 1) {
            System.out.println("参数不对");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= number; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(boy);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历单向环形链表
    public void show() {
        if (first == null) {
            System.out.println("链表为空,");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println(curBoy);
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //小孩出圈
    //思路：
    //1、创建一个辅助指针（变量）helper，事先应该指向环形链表的最后一个节点？（因为单向链表删除需要上一个节点辅助删除）
    //补充 ：小孩报数时，让first和helper移动 k(开始编号)-1 次
    //为啥-1？ 因为报数时是从1开始的
    //2、当小孩报数时，让first和helper指针同时移动m（数数的次数）-1次
    //3、这是就可以将first指向的小孩节点出圈，具体：
    // first=first.next
    //helper.next=first

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示圈内共有多少小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //数据校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数不对");
            return;
        }

        //创建一个辅助指针helper，帮助完成小孩出圈
        Boy helper = first;
        //创建一个辅助指针（变量）helper，事先应该指向环形链表的最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数时，让first和helper移动 k-1 次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，让first和helper指针同时移动m（数数的次数）-1次
        //这里是一个循环操作，直到圈子中只有一个节点
        //圈中只有一个节点条件 helper==first
        while (true) {
            if (helper == first) {
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点 就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩编号为："+helper.getNo());

    }


}

//小孩
class Boy {

    private int no;

    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy[no=" + getNo() + " next boy no=" + getNext().getNo() + "]";
    }
}
