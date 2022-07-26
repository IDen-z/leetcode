package com.zmz.leetcode.hot;

/**
 * 买卖股票的最佳时机
 */
public class MaxProfit121 {

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     */
    public int maxProfit(int[] prices) {
        // 这道题就是记录下之前的买入最小价格
        // 然后计算下当前买入价格和最小价格的最大差价
        // 正序遍历即可  因为必须卖出在买入之后
        int minPrice = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - minPrice);
            minPrice = Math.min(prices[i], minPrice);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProfit121 maxProfit121 = new MaxProfit121();
        maxProfit121.maxProfit(new int[]{3, 2, 6, 5, 0, 3});
    }

}
