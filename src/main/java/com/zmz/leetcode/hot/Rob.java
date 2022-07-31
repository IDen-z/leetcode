package com.zmz.leetcode.hot;

/**
 * 打家劫舍
 */
public class Rob {


    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
        // 动态规划
        if (nums.length==0){
            return 0;
        }
        // 这里+1很有必要 方便边界判断
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }


}
