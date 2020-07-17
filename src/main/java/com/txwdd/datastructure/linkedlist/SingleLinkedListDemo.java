package com.txwdd.datastructure.linkedlist;

/**
 * 单链表
 * 插入、更新、删除、遍历
 */
public class SingleLinkedListDemo {


    public static void main(String[] args) {

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟", null);
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星", null);
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头", null);

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(heroNode4);
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);


//        singleLinkedList.show();
//        System.out.println();
//        HeroNode heroNode5 = new HeroNode(4, "林冲", "豹子头aa", null);
//        singleLinkedList.update(heroNode5);
//        singleLinkedList.show();


        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.show();

        System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
    }
}


//单链表
class SingleLinkedList {

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
        } else {
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
        if (head.next == null) {
            System.out.println("链表为空");
            return 0;
        }
        int i = 0;
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            i++;
            temp = temp.next;
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
    // size:4 index:2  (4-2)
    public HeroNode findLastIndexNode(HeroNode head, int index) {
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

    //todo 单链表的反转





}

//水浒英雄 每个hero node就是单链表的一个节点
class HeroNode {

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName, HeroNode next) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.next = next;
    }

    @Override
    public String toString() {
        return "heroNode,no=[" + no + "],name=[" + name + "],nickName=[" + nickName + "]";
    }
}



