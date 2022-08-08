package com.zmz.leetcode.hot;

/**
 * 完全平方数
 */
public class NumSquares279 {


    /**
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     * <p>
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     */
    public int numSquares(int n) {
        // 动态规划解法
        // dp[i]表示每个数字的完全平方数的最小数量
        // 数字长度+1 是为了从1开始
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏情况是 每个都是+1 +1 +1
            dp[i] = i;
            // 否则则对每个数字进行循环
            for (int j = 1; i - j * j >= 0; j++) {
                // dp[i - j * j] + 1   这个加1 就是j*j 可以这么理解
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }


}
