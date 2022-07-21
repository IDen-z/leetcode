package com.zmz.leetcode.hot;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class BuildTree105 {

    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
     * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 递归构建
        // 前序遍历[根，左子树遍历结果，右子树遍历结果]
        // 中序遍历[左子树遍历结果，根，右子树遍历结果]
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildHelper(preorder, inorder, 0, map.size() - 1, 0, map.size() - 1, map);
    }

    public TreeNode buildHelper(int[] preorder, int[] inorder, int iLPre, int iRPre, int iLIn, int iRIn, HashMap<Integer, Integer> map) {
        // 递归终止条件
        if (iLPre > iRPre || iLIn > iRIn) {
            return null;
        }
        // 左子树节点的长度 中序序列中
        int k = map.get(preorder[iLPre]) - iLIn;
        TreeNode treeNode = new TreeNode(preorder[iLPre]);
        treeNode.left = buildHelper(preorder, inorder, iLPre + 1, iLPre + k, iLIn, iLIn + k - 1, map);
        treeNode.right = buildHelper(preorder, inorder, iLPre + k + 1, iRPre, iLIn + k + 1, iRIn, map);
        return treeNode;
    }

}
