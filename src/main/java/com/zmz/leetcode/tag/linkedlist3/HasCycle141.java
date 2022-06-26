package com.zmz.leetcode.tag.linkedlist3;

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
        // 这道题也可以利用hashSet 利用不重复的特性进行求解
        // 习惯性的将开辟空间惯性使用map结构 但是没考虑到合适的key value 结构


        if (head == null) {
            return false;
        }
        // 尝试将遍历过的Node的下个节点置为它本身
        // 如果循环结束没有发现类似的节点  就返回false
        ListNode index = head;
        ListNode pre = head;
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


}
