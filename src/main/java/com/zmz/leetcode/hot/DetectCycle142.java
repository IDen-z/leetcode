package com.zmz.leetcode.hot;

/**
 * 环形链表2
 */
public class DetectCycle142 {

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 不允许修改 链表。
     */
    public ListNode detectCycle(ListNode head) {
        // 不允许修改链表那么直接快慢指针即可
        // 第一思路是快慢指针 但是快慢指针相遇的位置不一定是环的起始位置
        // 需要进行调整 可以看https://leetcode.cn/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
        // 图解 可以发现 从头节点开始出发 a+nb a为前链的长度 b为环的长度
        // 第一次重合走了 快指针 走了 nb的长度，慢指针走了b
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        int flag = 0;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;

    }


}
