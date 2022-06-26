package com.zmz.leetcode.tag.linkedlist3;

/**
 * 相交链表
 */
public class GetIntersectionNode160 {


    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * <p>
     * 图示两个链表在节点 c1 开始相交：
     * <p>
     * 题目数据 保证 整个链式结构中不存在环。
     * <p>
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int l1 = 0;
        int l2 = 0;
        // 遍历三次 获得两个链表的长度
        // 第三次共同便利
        ListNode index1 = headA;
        ListNode index2 = headB;
        while (index1 != null) {
            l1++;
            index1 = index1.next;
        }
        while (index2 != null) {
            l2++;
            index2 = index2.next;
        }
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < l2 - l1; i++) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    // 上面是个人思路
    // 官方题解的思路非常巧妙 通过互相循环来消除链表长度的差距
    // 代码非常简练

}
