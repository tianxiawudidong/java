package com.txwdd.lettcode;

/**
 * 反转链表
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListReverse {

    public static void main(String[] args) {

        Linked head = new Linked(1);
        head.next = new Linked(2);
        head.next.next = new Linked(3);
        head.next.next.next = new Linked(4);
        head.next.next.next.next = new Linked(5);
        print(head);
        System.out.println();
        Linked reverse = reverse(head);
        print(reverse);


    }

    private static Linked reverse(Linked head) {
        Linked pre = null;
        Linked curr = head;
        while (curr != null) {
            Linked temp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;

        //1

    }

    private static void print(Linked head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.value + "-->");
            head = head.next;
        }
    }
}

class Linked {
    public int value;
    public Linked next;

    public Linked(int value) {
        this.value = value;
    }

}
