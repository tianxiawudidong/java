package com.txwdd.datastructure.linkedlist;

/**
 * 单链表 面试题
 */
public class SingleLinkedListInterview {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟", null);
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星", null);
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头", null);

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

        singleLinkedList.show();

        //1、计算单链表的有效元素个数
//        getLength(head);

        //2、查找单链表中倒数第k个节点
//        HeroNode node = findLastIndexNode(head, 2);

        //3、单链表的反转
//        System.out.println("单链表反转...");
//        singleLinkedList.reverseNode(singleLinkedList.getHead());
//
//        singleLinkedList.show();

        //4、从尾到头打印单链表 【使用栈】
        System.out.println("从尾到头打印单链表...");
        singleLinkedList.reversePrint(singleLinkedList.getHead());
    }




}
