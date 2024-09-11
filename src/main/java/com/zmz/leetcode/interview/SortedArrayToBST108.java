package com.zmz.leetcode.interview;

public class SortedArrayToBST108 {

    // 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
    //平衡
    // 二叉搜索树。
    //
    //输入：nums = [-10,-3,0,5,9]
    //输出：[0,-3,9,-10,null,5]
    //解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        // [-10,-3,0,5,9]

        // 其实就是递归不断的找根节点与左右节点
        // 根节点永远都是有序数组段的中间位置
        // 不断分治
        if (nums.length == 0) {
            return null;
        }

        TreeNode root = buildNode(nums, 0, nums.length - 1);
        return root;
    }

    private static TreeNode buildNode(int[] nums, int l, int r) {
        // 递归终止条件
        if (r - l < 0) {
            // 树节点        //的最终节点都是null
            return null;
        }
        int mid = (r - l) / 2 + l;
        // 0 5    0  2  3 5
        //       0 1 2 2  3  4  5 5
        TreeNode treeNode = new TreeNode(nums[mid]);
        // 构建左节点
        treeNode.left = buildNode(nums, l, mid - 1);
        treeNode.right = buildNode(nums, mid + 1, r);
        return treeNode;
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
