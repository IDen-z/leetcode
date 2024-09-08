package com.zmz.leetcode.interview;

public class HasCycle141 {
    // 给你一个链表的头节点 head ，判断链表中是否有环。
    //
    //如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
    // 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
    //
    //如果链表中存在环 ，则返回 true 。 否则，返回 false 。

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {

        // 快慢指针 // TODO 这里可以不要把快慢指针放到同一个起点里 head  head.next 这样可以省区boolean的判断
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while (fast != null) {
            if (flag && fast == slow) {
                return true;
            }
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            flag = true;
        }
        return false;

    }


}
