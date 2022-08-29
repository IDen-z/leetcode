package com.zmz.leetcode.hot;

/**
 * 路径总和
 */
public class PathSum437 {

    /**
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * <p>
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // dfs递归查找 不需要一定是从根节点开始 也就是说可以根节点的左右子树也需要考虑
        // 也就是根节点的左右节点的数目累加
        return (int) dfsFind(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private long dfsFind(TreeNode node, long targetSum) {
        if (node == null) {
            return 0;
        }
        long result = 0;
        if (node.val == targetSum) {
            result++;
        }
        result += dfsFind(node.left, targetSum - node.val) + dfsFind(node.right, targetSum - node.val);
        return result;
    }


}
