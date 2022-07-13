package com.zmz.leetcode.hot;

/**
 * 接雨水
 */
public class Trap42 {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public int trap(int[] height) {
        // 这道题的思路主要在于 计算出每个块的可接雨水的大小
        // 利用两次动态规划
        int res = 0;
        if (height.length == 0) {
            return res;
        }
        int n = height.length;
        // 求当前位置左侧的最高柱子长度
        int[] dpL = new int[n];
        int[] dpR = new int[n];
        for (int i = 1; i < n; i++) {
            dpL[i] = Math.max(dpL[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dpR[i] = Math.max(dpR[i + 1], height[i + 1]);
        }
        // 第三次循环计算每个格子的雨水并且累加
        for (int i = 1; i < n - 2; i++) {
            res += Math.min(dpL[i], dpR[i]) > height[i] ? Math.min(dpL[i], dpR[i]) - height[i] : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Trap42 trap42 = new Trap42();
        trap42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

}
