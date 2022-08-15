package com.zmz.leetcode.hot;

/**
 * 最佳买卖股票时机含冷冻期
 */
public class MaxProfit309 {

    /**
     * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
     * <p>
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * <p>
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public int maxProfit(int[] prices) {
        // 计算 股票的最大利润
        // 这里需要利用二维dp数组
        // dp[i][j] 表示第i天中股票卖出所获得的最大收益
        // j 有三种状态 0表示不持有股票 1表示持有股票 2表示当天是冷冻期
        int[][] dp = new int[prices.length][2];
        // 初始化dp数组
        dp[0][0] = 0;
        // 表示第一天花钱买股票了
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 不持有股票的情况 不买 或者 是把上一天的持有卖掉了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 持有股票 昨天的继续持有，或者 前天的卖掉 今日买入 因为有一天的冷冻期 因此要前天的i-2
            dp[i][1] = Math.max(dp[i - 1][1], (i - 2 >= 0 ? dp[i - 2][0] : 0) - prices[i] );
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,0,2};
        MaxProfit309 maxProfit309 = new MaxProfit309();
        int i = maxProfit309.maxProfit(nums);
    }

}
