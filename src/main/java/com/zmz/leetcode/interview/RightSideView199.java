package com.zmz.leetcode.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideView199 {

    // 给定一个二叉树的 根节点 root，想象自己站在它的右侧，
    // 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    //
    //
    //
    //示例 1:
    //
    //
    //
    //输入: [1,2,3,null,5,null,4]
    //输出: [1,3,4]
    //示例 2:
    //
    //输入: [1,null,3]
    //输出: [1,3]
    //示例 3:
    //
    //输入: []
    //输出: []
    //

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        // 示例树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        rightSideView(root);
    }

    public static List<Integer> rightSideView(TreeNode root) {


        // 这道题可以转换为层序遍历
        // 层序遍历需要一个 先进先出的队列 记录处理顺序
        // 当队列为空时 表示所有的节点都遍历完了
        // 双端队列模拟 栈 普通队列就是队列
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }


        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 打印当前数据
            // TODO 每层的节点数 知道这个这道题就好做了
            int i = queue.size();
            while (i != 0) {
                System.err.println(queue.peek().val);
                TreeNode node = queue.poll();
                // 左节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                // 右节点
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (--i == 0) {
                    res.add(node.val);
                }
            }

        }
        return res;

    }

}
