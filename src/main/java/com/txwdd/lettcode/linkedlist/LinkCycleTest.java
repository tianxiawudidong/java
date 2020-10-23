package com.txwdd.lettcode.linkedlist;

/**
 * 判断链表是否有环
 */
public class LinkCycleTest {

    private static class ListNode{
        private ListNode next;
        int value;
        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        //创建环路
        node.next.next.next.next.next = node;
        boolean flag = hasCircle(node);
        System.out.println(flag);
    }

    //判断链表是否为有环链表
    private static boolean hasCircle(ListNode node){
        ListNode s = node;
        ListNode f = node;
        while(true){
            //一次一两步
            s = s.next;
            //一次走两步
            f = f.next.next;
            //假如是有环链表那么返回true
            if(s == f)return true;
            //假如是无环链表那么返回false
            if(f.next == null) return false;
        }
    }
}
