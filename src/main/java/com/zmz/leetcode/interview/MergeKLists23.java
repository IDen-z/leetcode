package com.zmz.leetcode.interview;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */

public class MergeKLists23 {

    public static void main(String[] args) {
        // 示例输入
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        MergeKLists23 solution = new MergeKLists23();
        ListNode result = solution.mergeKLists(lists);

        // 打印结果链表
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }

    // TODO 这道题也可以用优先队列求解


    public ListNode mergeKLists(ListNode[] lists) {
        // 分治法
        return merge(lists, 0, lists.length - 1);

    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoList(ListNode node1, ListNode node2) {
        // 使用双指针
        ListNode head = new ListNode();
        ListNode pre = new ListNode();
        head = pre;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                pre.next = node1;
                node1 = node1.next;
            } else {
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }
        if (node1 != null) {
            pre.next = node1;
        } else {
            pre.next = node2;
        }
        return head.next;

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
