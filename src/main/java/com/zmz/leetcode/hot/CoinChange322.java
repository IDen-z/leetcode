package com.zmz.leetcode.hot;

import java.util.ArrayList;

/**
 * 零钱兑换
 */
public class CoinChange322 {


    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     */
    Integer res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        // 该题联想到利用dfs方法进行求解
        // 这种暴力递归会导致超时
        ArrayList<Integer> list = new ArrayList<>();
        dfsHelper(coins, amount, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void dfsHelper(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(count, res);
        }
        for (int coin : coins) {
            dfsHelper(coins, amount - coin, count + 1);
        }
    }

    public static void main(String[] args) {
        CoinChange322 coinChange322 = new CoinChange322();
        int[] nums = new int[]{2};
        int i = coinChange322.coinChangeOff(nums, 3);
        System.err.println(i);
    }


    public int coinChangeOff(int[] coins, int amount) {
        // 这题应该用动态规划的思路解题
        // dp[i] 表示 总金额为i的 最少可以有多少张零钱兑换
        // 初始化时 dp[0]=0 表示无需兑换
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0 || dp[i - coins[j]] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        if (dp[dp.length - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[dp.length - 1];
    }
}
