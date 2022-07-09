package com.zmz.leetcode.hot;


import java.util.List;

/**
 * 删除链表倒数第n个节点
 */
public class RemoveNthFromEnd19 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 利用快慢指针 当快指针指向链表末尾时，修改慢指针的下个节点即可
        // 设定指针
        ListNode res = new ListNode();
        res.next = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        RemoveNthFromEnd19 removeNthFromEnd19 = new RemoveNthFromEnd19();
        removeNthFromEnd19.removeNthFromEnd(listNode, 2);
    }


}
