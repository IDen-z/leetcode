package com.zmz.leetcode.hot;

/**
 * 相交链表
 */
public class GetIntersectionNode160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 这道题可以遍历A 再遍历B链 获取长度后再计算差值

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

    public ListNode getIntersectionNodeOff(ListNode headA, ListNode headB) {

        // 最优解法为两个指针 两个链表交替遍历
        ListNode preA = headA;
        ListNode preB = headB;
        while (preA != preB) {
            preA = preA.next;
            preB = preB.next;
            if (preA == preB) {
                break;
            }
            if (preA == null) {
                preA = headB;
            }
            if (preB == null) {
                preB = headA;
            }
        }
        return preA;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        GetIntersectionNode160 getIntersectionNode160 = new GetIntersectionNode160();
        getIntersectionNode160.getIntersectionNodeOff(a, b1);
    }

}
