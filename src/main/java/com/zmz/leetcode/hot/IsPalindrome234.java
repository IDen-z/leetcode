package com.zmz.leetcode.hot;


import java.util.Stack;

/**
 * 回文链表
 */
public class IsPalindrome234 {

    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     */
    public boolean isPalindrome(ListNode head) {
        // 利用一个栈
        ListNode index = head;
        Stack<Integer> stack = new Stack<>();
        while (index != null) {
            stack.add(index.val);
            index = index.next;
        }
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private ListNode frontNode;

    public boolean isPalindromeOff(ListNode head) {

        // 这道题的考察也可以用递归  但是递归也是On的空间复杂度
        frontNode = head;
        return dfsPalina(head);
    }

    /**
     * 递归的目的是反向遍历
     */
    private boolean dfsPalina(ListNode node) {
        if (node.next == null) {
            // 遍历到了 链表的尾部
            return node.val == frontNode.val;
        }
        boolean b = dfsPalina(node.next);
        if (b) {
            frontNode = frontNode.next;
            return node.val == frontNode.val;
        }
        return false;
    }


}
