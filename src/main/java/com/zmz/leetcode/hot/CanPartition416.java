package com.zmz.leetcode.hot;

/**
 * 分割等和子集
 */
public class CanPartition416 {


    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。
     * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     */
    public boolean canPartition(int[] nums) {
        // 01背包问题
        // 这题的解决思路在于 将其转化为
        // 能否在数组中挑取部分数字，使得挑取的数字和恰好等于数组总和的一半
        // 计算数组和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        // 初始化dp数组 dp[i][j]表示在第i个数字时 能否累加到目标j的大小
        int[][] dp = new int[nums.length + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {

                // 选择当前数字
                if (nums[i-1] == j) {
                    // 当前数字等于目标数值
                    dp[i][j] = 1;
                } else if (nums[i-1] < j) {
                    // 可以放弃当前数字 也可以 拿当前数字
                    if (dp[i - 1][j] == 1 || dp[i - 1][j - nums[i-1]] == 1) {
                        dp[i][j] = 1;
                    }
                } else {
                    // 当前数字大于目标数值
                    // 只能放弃当前数字
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum] == 1;
    }


}
