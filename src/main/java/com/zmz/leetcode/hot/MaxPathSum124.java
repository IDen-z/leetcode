package com.zmz.leetcode.hot;

/**
 * 二叉树中的最大路径和
 */
public class MaxPathSum124 {


    /**
     * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     * <p>
     * 路径和 是路径中各节点值的总和。
     * <p>
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    Integer res = Integer.MIN_VALUE;

    public int dfs(TreeNode node) {
        // 递归计算当前节点下 左子树的最大路径和 和 右子树的最大路径和
        if (node == null) {
            return 0;
        }
        // 这里之所以取最大值是因为如果递归出左子树为负值  那么不累加是更优的
        int leftMax = Math.max(dfs(node.left), 0);
        int rightMax = Math.max(dfs(node.right), 0);

        // 记录当前节点的遍历最大路径和是不是历史最大
        res = Math.max(res, node.val + leftMax + rightMax);

        // 这里是理解的重点 因为是路径最大和 不能走回头路 因此这里返回的只能是单边路径最大和
        // 因为返回的值是个上层节点用的 只能选择一个分支 除了根节点
        // 这也是为什么像后序遍历一样在最后累加res最大值
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        MaxPathSum124 maxPathSum124 = new MaxPathSum124();
        maxPathSum124.maxPathSum(root);

    }

}
