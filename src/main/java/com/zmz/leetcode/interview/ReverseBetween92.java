package com.zmz.leetcode.interview;

public class ReverseBetween92 {

    // 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
    // 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

    // 1  2  3  4  5

    // 输入：head = [1,2,3,4,5], left = 2, right = 4
    //输出：[1,4,3,2,5]
    //示例 2：
    //
    //输入：head = [5], left = 1, right = 1
    //输出：[5]

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseBetween(head, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        // 遍历链表
        if (head == null || left == right) {
            return head;  // 如果链表为空或反转范围只有一个节点，直接返回
        }

        // 找到left节点的前一个 移动到反转部分的前一个节点
        // 如果需要从1开始翻转 因此pre节点要到翻转部分的前一个节点 因此只能在头部分手动查一个节点
        ListNode first = new ListNode();
        first.next = head;

        ListNode pre = first;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        // 此时pre就到了需要翻转部分的前一个节点 如果 left=2，那么此时pre就是1
        ListNode current = pre.next;
        // 翻转到right结束
        for (int j = left; j < right; j++) {
            // 把 current节点的下一个节点移动到pre后面
            ListNode tmp = current.next;
            ListNode tmp2 = pre.next;
            current.next = current.next.next;
            pre.next = tmp;
            tmp.next = tmp2;
        }
        // 反转的 current 节点
        return first.next;
    }

    public static ListNode reverseBetweenTwo(ListNode head, int left, int right) {
        // 1 2 3 4 5   输入  2  4  表示第二个 到 第四个 进行翻转 每次都把节点插到1 后面就可以

        // 先找到开始循环的第一个节点的前一个节点
        // 找到这个节点的作用是在循环过程中 可以把每一个当前节点插入到这个前一个节点后面
        // 因此需要在链表的前面插一个初始节点 这样就是left从1 开始 也可以统一处理
        ListNode first = new ListNode();
        first.next = head;
        // first 1 2 3 4 5
        ListNode pre = first;
        // 索引节点 需要找到 开始循环的第一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // pre节点不变 每次都插当前循环节点的下一个节点
        ListNode current = pre.next;
        for (int i = left; i < right; i++) {
            ListNode tmp1 = current.next;
            ListNode tmp2 = pre.next;
            current.next = current.next.next;
            pre.next = tmp1;
            tmp1.next = tmp2;
        }
        return first.next;
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
