package com.zmz.leetcode.interview;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class CoinChange322 {

    // 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    //
    //计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    //
    //你可以认为每种硬币的数量是无限的。

    // 示例 1：
    //
    //输入：coins = [1, 2, 5], amount = 11
    //输出：3
    //解释：11 = 5 + 5 + 1
    //示例 2：
    //
    //输入：coins = [2], amount = 3
    //输出：-1
    //示例 3：
    //
    //输入：coins = [1], amount = 0
    //输出：0
    public static void main(String[] args) {
        CoinChange322 bean = new CoinChange322();
        bean.coinChange(new int[]{1}, 0);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        // 采用BFS 遍历
        // 转化为最小步骤
        // 每一步拿一个 硬币 最小步骤的硬币直接返回
        // 采用队列

        // 这道题中金额的累加应该进队列
        // 同事采用一个vist数组来过滤已经处理过的金额状态
        // 避免处理 1+1+1  1+2 进行重复处理

        // 初始化队列 与 处理数组
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[amount + 1];
        queue.offer(0);
        visited[0] = true;

        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 队列已存在的状态 要处理完
                Integer poll = queue.poll();
                for (int n = 0; n < coins.length; n++) {
                    int sum = poll + coins[n];
                    if (sum == amount) {
                        return res;
                    }
                    if (sum < amount && !visited[sum]) {
                        queue.offer(sum);
                        visited[sum] = true;
                    }
                }
            }
            res++;
        }
        return -1;

    }


}
