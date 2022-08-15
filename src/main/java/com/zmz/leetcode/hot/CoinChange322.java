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
    Integer res = -1;

    public int coinChange(int[] coins, int amount) {
        // 该题联想到利用dfs方法进行求解
        ArrayList<Integer> list = new ArrayList<>();
        dfsHelper(coins, amount, 0, list);


        return 0;
    }

    private void dfsHelper(int[] coins, int amount, int index, ArrayList<Integer> list) {
        



    }


}
