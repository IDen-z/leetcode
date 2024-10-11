package com.zmz.leetcode.interview;

import java.util.List;

public class MergeTwoLists21 {
    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：l1 = [1,2,4], l2 = [1,3,4]
    //输出：[1,1,2,3,4,4]
    //示例 2：
    //
    //输入：l1 = [], l2 = []
    //输出：[]
    //示例 3：
    //
    //输入：l1 = [], l2 = [0]
    //输出：[0]
    //

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        mergeTwoLists(listNode1,listNode4);


    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res = new ListNode();
        ListNode index = new ListNode();
        res = index;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                index.next = list1;
                list1 = list1.next;
            } else {
                index.next = list2;
                list2 = list2.next;
            }
            index = index.next;

        }

        if (list1 != null) {
            index.next = list1;
        } else {
            index.next = list2;
        }

        return res.next;
    }


    public static class ListNode {
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
