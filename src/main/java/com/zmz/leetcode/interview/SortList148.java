package com.zmz.leetcode.interview;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortList148 {

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

    // 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：head = [4,2,1,3]
    //输出：[1,2,3,4]
    //示例 2：
    //
    //
    //输入：head = [-1,5,3,4,0]
    //输出：[-1,0,3,4,5]
    //示例 3：
    //
    //输入：head = []
    //输出：[]

    public ListNode sortList(ListNode head) {

        Queue<Integer> queue = new PriorityQueue<>();

        while (head != null) {
            queue.offer(head.val);
            head = head.next;
        }
        if (queue.isEmpty()) {
            return null;
        }

        ListNode res = new ListNode();
        ListNode root = res;
        while (!queue.isEmpty()) {
            root.next = new ListNode(queue.poll());
            root = root.next;
        }
        return res.next;


    }

    //TODO 链表排序 主打归并
    // 链表排序
    public ListNode sortListOpt(ListNode head) {

        // 递归终止条件
        if (head.next == null) {
            return head;
        }

        // 截取链表
        ListNode midNode = getMiddle(head);
        ListNode midNodeNext = midNode.next;

        midNode.next = null;

        // 排序两个子序列
        ListNode left = sortListOpt(head);
        ListNode right = sortListOpt(midNodeNext);

        // 合并两个子序列
        ListNode node = mergeLinkList(left, right);

        return node;
    }

    // 合并两个有序子序列 合并两个有序链表
    private ListNode mergeLinkList(ListNode left, ListNode right) {
        ListNode root = new ListNode();
        ListNode index = root;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                index.next = left;
                left = left.next;
            } else {
                index.next = right;
                right = right.next;
            }
            index = index.next;
        }
        if (left != null) {
            index.next = left;
        } else if (right != null) {
            index.next = right;
        }
        return root.next;
    }

    // 获取指针的中间位置
    // 使用快慢指针
    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
