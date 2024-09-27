package com.zmz.leetcode.interview;

public class MaxSubarraySumCircular918 {

    // 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
    //
    //环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
    //
    //子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,-2,3,-2]
    //输出：3
    //解释：从子数组 [3] 得到最大和 3
    //示例 2：
    //
    //输入：nums = [5,-3,5]
    //输出：10
    //解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
    //示例 3：
    //
    //输入：nums = [3,-2,2,-3]
    //输出：3
    //解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3

    public static void main(String[] args) {
        int i = maxSubarraySumCircular(new int[]{1,-2,3,-2});
        System.err.println(i);
    }

    public static int maxSubarraySumCircular(int[] nums) {
        // 这道题相比较53题目 来说 多了一个数组循环的特征
        // 那么相比较于53题的动态规划
        // 只能解决无循环的子数组最大和

        if (nums.length <= 0) {
            return 0;
        }
        int res =nums[0];
        // 第一个动态规划数组 用来记录 到i为止的最大子数组和
        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];

        // 第二个动态规划数组 用来记录 到i为止的最大前缀和（必须从0开始）
        int[] dp2 = new int[nums.length];
        dp2[0] = nums[0];

        // 从左至右循环 求解无循环数组的最大值
        // 同时记录从0开始的前缀和dp
        int leftSum = dp2[0];
        for (int i = 1; i < nums.length; i++) {
            dp1[i] = Math.max(nums[i], dp1[i - 1] + nums[i]);
            res = Math.max(res, dp1[i]);

            leftSum += nums[i];
            dp2[i] = Math.max(dp2[i - 1], leftSum);
        }
        // 此时考虑第二种情况

        // 后缀和
        int rightSum = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            rightSum += nums[i];
            res = Math.max(res, rightSum + dp2[i - 1]);
        }


        return res;
    }


}
