package com.txwdd.datastructure.linkedlist;

import java.util.Stack;

public class SingleLinkedList {

    //先定义一个头节点，头节点不保存数据
    public HeroNode head = new HeroNode(0, "", "", null);

    public HeroNode getHead() {
        return head;
    }

    //添加元素到单链表
    //思路：
    //当不考虑编号顺序时，只需找到链表的尾部，
    // 然后将尾部的数据的next指向待插入的数据即可
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //按顺序添加元素到单链表
    //根据排名插入元素
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false; //标识插入的编号是否存在  默认为false
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("待添加的元素编号%d已经存在", heroNode.no);
            System.out.println();
        } else { //带插入 3
            // 1--》2 --》4
            //  3--》4
            //2--》3
            //  1--》2 --》3--》4
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息 根据no来修改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.nickName = newHeroNode.nickName;
            temp.name = newHeroNode.name;
        } else {
            System.out.printf("没有找到编号为%d的节点", newHeroNode.no);
        }
    }

    //删除 根据编号删除
    //找到待删除节点的上一个节点，然后将该节点的next指向该节点的next.next
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到编号为%d的节点", no);
        }
    }

    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    //查询单链表的有效节点个数
    public int getLength(HeroNode head) {
        int i = 0;
        if (head.next == null) {
            System.out.println("链表为空");
        } else {
            HeroNode temp = head.next;
            while (temp != null) {
                i++;
                temp = temp.next;
            }
        }
        return i;
    }

    //查找单链表中的倒数第k个元素
    //思路
    //1、编写一个方法 接收两个参数 parameter1：HeroNode头节点 parameter2：index
    //2、index：表示倒数第index个节点
    //3、先把链表从头遍历，得到链表的长度size
    //4、得到size后，从头开始遍历（size-index）个
    //5、如果有值就返回，否则返回null
    // size:4 index:2  (4-2)   head->1-->2-->3-->4
    private HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            System.out.println("链表为空");
            return null;
        }
        //第一次遍历得到链表的长度
        int size = getLength(head);
        //第二次遍历 得到size后，从头开始遍历（size-index）个
        if (size <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //思路
    //1、先定义一个节点 reverseNode=new HeroNode()
    //2、遍历之前的链表，每遍历一个元素，则将该元素放在reverseNode 的最前端 即reverseNode.next
    //3、将原来的链表指向新链表 head.next=reverseNode.next
    // linked list: head -->1--->3 -->5--->9
    // reverseNode：head2->9->5->3->1  ===>head ->9->5->3->1
    //缺点：破坏原来的链表结构
    public void reverseNode(HeroNode head) {
        //如果链表只有一个元素 或者链表为空 则无需反转
        if (head.next == null || head.next.next == null) {
            System.out.println("链表只有一个元素或者链表为空");
            return;
        }
        //指向原来的链表
        HeroNode cur = head.next;
        HeroNode next;  //指向当前节点【cur】的下一个节点
        HeroNode reverseNode = new HeroNode(0, "", "");

        //遍历原来的链表，每取出一个 便将元素放在reverseNode的最前端
        while (cur != null) {
            next = cur.next;
            cur.next = reverseNode.next;
            reverseNode.next = cur;
            cur = next;
        }
        head.next = reverseNode.next;
    }

    public void reversePrint(HeroNode head) {
        if (head.next == null) {
            System.out.println("链表链表为空");
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        //入栈
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur=cur.next;
        }

        while (stack.size()>0){
            HeroNode pop = stack.pop();
            System.out.println(pop);
        }


    }

}
