package com.zmz.leetcode.hot;

/**
 * 买卖股票的最大时机
 */
public class MaxProfit122 {
    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * <p>
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * <p>
     * 返回 你能获得的 最大 利润 。
     */
    public int maxProfit(int[] prices) {
        // 这道题其实就是把数组中的上升序列的和累加起来
        // 无论怎么操作 都是最高点和最低点的收益  所以正序遍历 累加上升序列和即可
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }
        return res;
    }

}
