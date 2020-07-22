package com.txwdd.datastructure.linkedlist;

public class HeroNode {

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

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
