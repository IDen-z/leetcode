package com.zmz.leetcode.tag.linkedlist3;

/**
 * 删除排序链表中的重复元素
 */
public class DeleteDuplicates83 {

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode();
        res = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                // 如果值相当
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        DeleteDuplicates83 deleteDuplicates83 = new DeleteDuplicates83();
        deleteDuplicates83.deleteDuplicates(a1);
    }

}
