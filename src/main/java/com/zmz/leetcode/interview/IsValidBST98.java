package com.zmz.leetcode.interview;

public class IsValidBST98 {

    // 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    //
    //有效 二叉搜索树定义如下：
    //
    //节点的左子树只包含 小于 当前节点的数。
    //节点的右子树只包含 大于 当前节点的数。
    //所有左子树和右子树自身必须也是二叉搜索树。

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        // 递归进行条件验证
        return dfsMetod(root, null, null);
    }

    private boolean dfsMetod(TreeNode node, Long low, Long up) {
        if (node == null) {
            // 空树到底也是二叉搜索树
            return true;
        }
        int val = node.val;
        // 从顶 到低  为null说明无限制，直接跳过比较
        if (low != null && val <= low) {
            return false;
        }
        if (up != null && val >= up) {
            return false;
        }
        if (!dfsMetod(node.left, low, (long) val)) {
            return false;
        }
        if (!dfsMetod(node.right, (long) val, up)) {
            return false;
        }
        return true;
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


