package com.zmz.leetcode.hot;


/**
 * 合并K个升序链表
 */
public class MergeKLists23 {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 这样的解法是暴力递归解法 绝对不是最优解
        // 这种是顺序比较 合并次数虽然一样 但是比较次数较多
        // 可以利用分治进行比较次数的优化

        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return dfs(lists[0], 1, lists);
    }

    public ListNode dfs(ListNode node, int index, ListNode[] lists) {
        if (index == lists.length - 1) {
            return mergeTwoLists(node, lists[index]);
        } else {
            ListNode listNode = mergeTwoLists(node, lists[index]);
            return dfs(listNode, index + 1, lists);
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 第一反应用双指针
        // 两个有序数组各从低至高用指针指向
        // 这道题的关键在于需要一个头节点 和 前节点
        ListNode head = new ListNode();
        ListNode pre = new ListNode();
        head = pre;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        pre.next = list1 == null ? list2 : list1;

        return head.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;


        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);
        c1.next = c2;

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = a1;
        listNodes[1] = b1;
        listNodes[2] = c1;
        MergeKLists23 mergeKLists23 = new MergeKLists23();
        ListNode listNode = mergeKLists23.mergeKLists(listNodes);

    }

}
