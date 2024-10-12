package com.zmz.leetcode.interview;

public class InvertTree226 {


    // 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

    public TreeNode invertTree(TreeNode root) {

        dfsMethod(root);

        return root;
    }

    private void dfsMethod(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        dfsMethod(node.left);
        dfsMethod(node.right);
    }


    public class TreeNode {
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
