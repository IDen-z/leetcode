package com.zmz.leetcode.hot;

/**
 * 乘积最大子数组
 */
public class MaxProduct152 {


    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     * 测试用例的答案是一个 32-位 整数。
     * <p>
     * 子数组 是数组的连续子序列。
     */
    public int maxProduct(int[] nums) {
        // 这道题其实就维护下最大变量和最小变量即可
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a = max * nums[i];
            int b = min * nums[i];
            max = Math.max(nums[i], Math.max(a, b));
            min = Math.min(nums[i], Math.min(a, b));
            res = Math.max(res, max);
        }
        return res;
    }

    /**
     * 也可以采用动态规划
     *
     * 只需要同时定义两个dp数组即可
     */


}
