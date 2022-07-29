package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 排序链表
 */
public class SortList148 {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     */
    public ListNode sortList(ListNode head) {
        // 加入list 手动排序后重构
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        list.sort(Integer::compareTo);
        ListNode pre = new ListNode();
        ListNode res = pre;
        for (Integer i : list) {
            ListNode c = new ListNode(i);
            pre.next = c;
            pre = pre.next;
        }
        return res.next;

    }


}
