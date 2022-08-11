package com.zmz.leetcode.hot;

/**
 * 最长递增子序列
 */
public class LengthOfLIS300 {

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     */
    public int lengthOfLIS(int[] nums) {

        // 动态规划
        // dp[i] 表示以当前第i个字符结尾的最大递增子序列的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int index = i - 1;
            dp[i] = 1;
            while (index >= 0) {
                if (nums[i] > nums[index]) {
                    // 如果当前值比nums[index]大
                    dp[i] = Math.max(dp[i], dp[index] + 1);
                    // 这里不能break
                    // break;
                }
                index--;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LengthOfLIS300 lengthOfLIS300 = new LengthOfLIS300();
        int i = lengthOfLIS300.lengthOfLIS(nums);
        System.err.println(i);
    }


    /**
     * 更合理的题解
     */
    public int lengthOfLISOff(int[] nums) {
        // 上述的动态规划的时间复杂度为On2
        // 利用动态规划 + 二分查找可以将其降为On logn


        return 0;
    }


}
