package com.zmz.leetcode.interview;

public class KthSmallest230 {

    // 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
    // 请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：root = [3,1,4,null,2], k = 1
    //输出：1
    //示例 2：
    //
    //
    //输入：root = [5,3,6,2,4,null,null,1], k = 3
    //输出：3

    public static void main(String[] args) {
        // 初始化树节点
        TreeNode root = new TreeNode(4);   // 根节点 4
        root.left = new TreeNode(2);       // 左节点 2
        root.right = new TreeNode(5);      // 右节点 5
        root.left.right = new TreeNode(3); // 2 的右节点 3

        KthSmallest230 bean = new KthSmallest230();
        bean.kthSmallest(root, 1);

        // 树的结构已经初始化好
        System.out.println("Binary Tree initialized!");
    }

    int n = 0;
    Integer res = null;

    public int kthSmallest(TreeNode root, int k) {
        // 二叉搜索树 中序遍历是有序的
        dfsMethod(root, k);
        return res;
    }

    private void dfsMethod(TreeNode root, int k) {
        if (root == null || res != null) {
            return;
        }
        dfsMethod(root.left, k);
        n++;
        if (n == k) {
            res = root.val;
            return;
        }
        dfsMethod(root.right, k);
    }

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

}
