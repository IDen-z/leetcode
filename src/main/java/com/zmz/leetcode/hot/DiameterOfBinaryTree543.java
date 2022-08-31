package com.zmz.leetcode.hot;

/**
 * 二叉树的直径
 */
public class DiameterOfBinaryTree543 {

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。
     * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     */

    public int diameterOfBinaryTree(TreeNode root) {
        len = 1;
        dfsHelper(root);
        return len - 1;
    }

    /**
     * 计算当前节点的最大直径
     */

    int len = 0;

    private int dfsHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfsHelper(node.left);
        int r = dfsHelper(node.right);
        // 这个是计算直径结果
        len = Math.max(len, l + r + 1);
        // 返回的是左右子树的最大深度
        return Math.max(l, r) + 1;
    }

}
