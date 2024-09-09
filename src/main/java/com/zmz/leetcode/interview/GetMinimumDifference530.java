package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class GetMinimumDifference530 {

    // 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
    //
    //差值是一个正数，其数值等于两值之差的绝对值。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：root = [4,2,6,1,3]
    //输出：1
    //示例 2：
    //
    //
    //输入：root = [1,0,48,null,null,12,49]
    //输出：1
    //

    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        getMinimumDifference(root);
    }


    public static int getMinimumDifference(TreeNode root) {
        // 二叉搜索树 中序遍历后是从小到大的序列
        TreeNode index = root;
        int res = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
//        list.add(Integer.MIN_VALUE);
        getMinDfs(root, list);

        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, list.get(i) - list.get(i - 1));
        }

        return res;

    }

    private static void getMinDfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            getMinDfs(node.left, list);
        }

        list.add(node.val);

        if (node.right != null) {
            getMinDfs(node.right, list);
        }

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
