package com.zmz.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class BuildTree105 {

    // 给定两个整数数组 preorder 和 inorder ，
    // 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
    // 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    //输出: [3,9,20,null,null,15,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 根据前序遍历和中序遍历  构建二叉树
        // 前序遍历的数组首位是根节点
        // 遍历出根节点在中序遍历中的索引位置 方便分割数组
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            // key是数值 value是索引位置
            map.put(inorder[i], i);
        }

        TreeNode root = dfsHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
        return root;
    }

    // 每次把根节点的左右两个子节点分开处理
    private TreeNode dfsHelper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preEnd < preStart || inEnd < inStart) {
            // 说明数组已经分割完了 不需要再构建了
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        // 获取根节点 在 中序遍历中的索引位置
        int index = map.get(preorder[preStart]);

        root.left = dfsHelper(preorder, preStart + 1, preStart + (index - inStart), inStart, index - 1, map);
        root.right = dfsHelper(preorder, preStart + 1 + (index - inStart), preEnd, index + 1, inEnd, map);

        return root;
    }


    public TreeNode buildTreeTwo(int[] preorder, int[] inorder) {
        // 前序遍历的第一个节点是当前根节点
        // 中序遍历数组的 当前根节点左右两边分别是左子节点的中序遍历数组 和 右子节点的中序遍历数组
        Map<Integer, Integer> map = new HashMap<>();
        // 构建一个map 记录前序遍历的根节点对应在中序遍历的位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfsMethod(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode dfsMethod(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {

        // 递归终止条件判断
        if (preEnd < preStart || inEnd < inStart) {
            // 中序或者前序数组不够用了
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        // index 表示 根节点在中序遍历数组中的位置
        int index = map.get(preorder[preStart]);

        // 计算 左子树 下一个前序遍历数组的开始位置 和 结束位置
        // 开始 preStart+1    preStart+(index-inStart)

        // 计算 左子树 下一个中序遍历数组的开始位置 和 结束位置
        // 开始 inStrat     index-1


        // 计算 右子树 下一个前序遍历数组的开始位置 和 结束位置
        // 开始 preStart+(index-inStart)+1   preEnd

        // 计算 右子树 下一个中序遍历数组的开始位置 和 结束位置
        // 开始 index+1     inENd

        root.left = dfsMethod(preorder, preStart+1, preStart+(index-inStart), inStart, index - 1, map);
        root.right = dfsMethod(preorder, preStart + (index - inStart) + 1, preEnd, index + 1, inEnd, map);
        return root;
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
