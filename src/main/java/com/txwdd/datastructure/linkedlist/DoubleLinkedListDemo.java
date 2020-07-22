package com.txwdd.datastructure.linkedlist;

/**
 * 双向链表
 * 与单向链表的区别 :
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(heroNode2);
        doubleLinkedList.addByOrder(heroNode1);
        doubleLinkedList.addByOrder(heroNode3);
        doubleLinkedList.addByOrder(heroNode4);

        doubleLinkedList.list();

    }
}

class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //遍历
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next; //向后遍历
//            temp = temp.pre; //向前遍历
        }
    }

    //添加元素到单链表
    //思路：
    //当不考虑编号顺序时，只需找到链表的尾部，
    // 然后将尾部的数据的next指向待插入的数据即可
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    //按顺序添加元素到单链表
    //根据排名插入元素
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
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
            if(null !=temp.next){
                heroNode.next = temp.next;
                temp.next.pre=heroNode;
            }
            heroNode.pre=temp;
            temp.next = heroNode;

        }
    }

    //删除 根据编号删除
    //找到待删除的节点
    //delNode.pre.next=delNode.next
    //delNode.next.pre=delNode.pre
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //NPE
            //如果待删除的节点是链表的最后一个节点
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("没有找到编号为%d的节点", no);
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 pre; //上一个节点
    public HeroNode2 next; //下一个节点

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode2(int no, String name, String nickName, HeroNode2 next, HeroNode2 pre) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.next = next;
        this.pre = pre;
    }

    @Override
    public String toString() {
        String nextNo = null != next ? "" + next.no : "";
        String s = "heroNode2,no=[" + no + "],name=[" + name
            + "],nickName=[" + nickName + "],preNo=[" + pre.no + "],nextNo=[" + nextNo + "]";
        return s;
    }


}
