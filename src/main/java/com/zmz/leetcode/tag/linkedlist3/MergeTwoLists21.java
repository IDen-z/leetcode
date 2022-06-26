package com.zmz.leetcode.tag.linkedlist3;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists21 {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 第一反应用双指针
        // 两个有序数组各从低至高用指针指向


        // 这道题的关键在于需要一个头节点 和 前节点
        ListNode head = new ListNode();
        ListNode pre = new ListNode();
        head.next = pre;
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
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;


        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(3);
        b1.next = b2;
        b2.next = b3;

        MergeTwoLists21 mergeTwoLists21 = new MergeTwoLists21();
        mergeTwoLists21.mergeTwoLists(a1, b1);
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
