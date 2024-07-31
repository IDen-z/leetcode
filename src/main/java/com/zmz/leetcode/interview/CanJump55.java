package com.zmz.leetcode.interview;

public class CanJump55 {

    // 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //
    //判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,3,0,1,4]
    //输出：true
    //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    //示例 2：
    //
    //输入：nums = [3,2,1,0,4]
    //输出：false
    //解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

    public boolean canJump(int[] nums) {
        // 动态规划
        // dp[i] 表示数组第[i]个位置是否可达
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        // [2,3,1,1,4]
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && (i - j) <= nums[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public boolean canJump2(int[] nums) {
        // 倒着跳 看能否到达初始位置
        int target = nums.length - 1;
        // target表示最终到达的位置
        int i = target - 1;
        while (i >= 0) {
            if (nums[i] + i >= target) {
                target = i;
            }
            i--;
        }
        return target == 0;
    }

}
