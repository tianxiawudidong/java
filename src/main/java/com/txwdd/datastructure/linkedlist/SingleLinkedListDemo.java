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
