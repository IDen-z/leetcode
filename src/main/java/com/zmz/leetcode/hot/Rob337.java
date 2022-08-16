package com.zmz.leetcode.hot;

/**
 * 打家劫舍
 */
public class Rob337 {

    /**
     * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
     * <p>
     * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
     * <p>
     * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
     */
    public int rob(TreeNode root) {
        // 暴力dfs解法
        int res = 0;
        return dfsHelper(root);
    }


    private int dfsHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int money = node.val;
        // 计算孙子节点的最大偷钱数
        if (node.left != null) {
            money += (rob(node.left.left) + rob(node.left.right));
        }
        if (node.right != null) {
            money += rob(node.right.left) + rob(node.right.right);
        }
        // 比较儿子节点的偷钱数
        return Math.max(money, rob(node.left) + rob(node.right));
    }


    public int robOff(TreeNode root) {
        // 上述的dfs暴力解法 有很多层的重复计算
        // 利用动态规划 节省重复计算
        int[] ints = dfsSolve(root);
        return Math.max(ints[0], ints[1]);
    }


    public int[] dfsSolve(TreeNode node) {
        // 递归终止条件
        if (node == null) {
            return new int[]{0, 0};
        }
        // 这里要用后序遍历
        int[] left = dfsSolve(node.left);
        int[] right = dfsSolve(node.right);
        // 0 表示不偷 1 表示偷
        // 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
        //当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = left[0] + right[0] + node.val;
        return dp;
    }

}
