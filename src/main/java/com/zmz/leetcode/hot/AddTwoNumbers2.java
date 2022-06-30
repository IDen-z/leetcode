package com.zmz.leetcode.hot;

import java.util.List;

/**
 * 两数相加
 */
public class AddTwoNumbers2 {


    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 这道题的第一反应是遍历 将每个链表转成整数进行相加
        // 得到结果后再还原成链表 暴力解法

        // 官方题解推荐模拟
        // 若某个链表长度不够，相当于补0

        // 通过该变量记录进位
        int carry = 0;
        ListNode res = new ListNode();
        ListNode pre = new ListNode();
        pre = res;
        while (l1 != null || l2 != null) {
            int cur = 0;
            // 链表不结束 一直循环
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            carry = v1 + v2 + carry;
            if (carry >= 10) {
                cur = carry % 10;
                carry = 1;
            } else {
                cur = carry;
                carry = 0;
            }
            ListNode node = new ListNode(cur);
            res.next = node;
            res = res.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 这块是容易出错的 当carry不为0时 表示末位还需要进位1
        if (carry != 0) {
            res.next = new ListNode(1);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;
        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
        addTwoNumbers2.addTwoNumbers(l1, r1);
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}