package com.zmz.leetcode.interview;

public class CopyRandomList138 {

    public static void main(String[] args) {
        // 创建一个示例链表
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        // 进行深拷贝
        CopyRandomList138 solution = new CopyRandomList138();
        Node newHead = solution.copyRandomList(node1);

        // 打印结果
        Node current = newHead;
        while (current != null) {
            System.out.println("Value: " + current.val + ", Random Value: " + (current.random != null ? current.random.val : "null"));
            current = current.next;
        }
    }

    // 链表中的任何节点或空节点。
    //
    //构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
    //
    //例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
    //
    //返回复制链表的头节点。
    //
    //用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
    //
    //val：一个表示 Node.val 的整数。
    //random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
    //你的代码 只 接受原链表的头节点 head 作为传入参数。


    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 分成三步
        // 1 仅拷贝 节点 同时把 next 节点指到原链表的对应节点
        Node index = head;
        while (index != null) {
            // TODO 链表的处理while循环时 什么时候.next 什么时候判断当前节点
            // 把 new node 插入到原位置
            // 1-->2  变成   1-->1(new)-->2
            Node newNode = new Node(index.val);
            newNode.next = index.next;
            index.next = newNode;
            index = index.next.next;
        }
        // 循环结束 此时拷贝的新节点已经进入原链表
        // 此时开始复制random节点 此时 节点的random的next节点 就是深拷贝出的目标random节点
        Node index2 = head;
        while (index2.next != null) {
            if (index2.random != null) {
                index2.next.random = index2.random.next;
            }
            index2 = index2.next.next;
        }
        // 把原链表和复制链表断开
        Node newHead = head.next;  // 新链表的头节点
        Node originalCurrent = head;
        Node copyCurrent = newHead;

        while (originalCurrent != null) {
            originalCurrent.next = originalCurrent.next.next;  // 恢复原链表的结构
            if (copyCurrent.next != null) {
                copyCurrent.next = copyCurrent.next.next;  // 设置新链表的 next
            }
            originalCurrent = originalCurrent.next;
            copyCurrent = copyCurrent.next;
        }

        return newHead;
    }


   static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}

