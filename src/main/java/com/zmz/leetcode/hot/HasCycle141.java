package com.zmz.leetcode.hot;

import java.util.List;

/**
 * 环形链表
 */
public class HasCycle141 {

    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     * <p>
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     */
    public boolean hasCycle(ListNode head) {
        // 思路一 快慢指针 慢指针走一步 快指针走两步 有环就会相遇 这种方法会改变自身链表
        // 思路二 遍历时将节点的下一个指向只给本身
        if (head == null) return false;
        ListNode pre = head;
        ListNode index = head;
        while (index.next != null) {
            if (index.next == index.next.next) {
                return true;
            }
            index = index.next;
            pre.next = pre;
            pre = index;
        }
        return false;
    }

    public boolean hasCycleOff(ListNode head) {
        // 思路一 快慢指针 慢指针走一步 快指针走两步 有环就会相遇
        // 思路二 遍历时将节点的下一个指向只给本身
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

    }


}
