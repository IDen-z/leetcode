package com.zmz.leetcode.interview;

import java.util.List;

public class AddTwoNumbers2 {

    // 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    //
    //请你将两个数相加，并以相同形式返回一个表示和的链表。
    //
    //你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    // 输入：l1 = [2,4,3], l2 = [5,6,4]  342 + 21
    //输出：[7,0,8]
    //解释：342 + 465 = 807.
    //示例 2：
    //
    //输入：l1 = [0], l2 = [0]
    //输出：[0]
    //示例 3：
    //
    //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    //输出：[8,9,9,9,0,0,0,1]


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 顺序累加即可

        // 记录进位
        int carry = 0;
        ListNode root = new ListNode();
        ListNode res = new ListNode();
        root = res;
        ListNode i = l1;
        ListNode j = l2;
        while (i != null || j != null) {
            int sum = 0;
            int numi = 0;
            int numj = 0;
            if (i != null) {
                numi = i.val;
                i = i.next;
            }
            if (j != null) {
                numj = j.val;
                j = j.next;
            }
            sum += carry + numi + numj;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            res.next = node;
            res = res.next;
        }
        if (carry != 0) {
            res.next = new ListNode(carry);
        }


        return root.next;
    }

    public class ListNode {
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


}
