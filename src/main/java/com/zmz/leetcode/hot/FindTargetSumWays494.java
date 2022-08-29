package com.zmz.leetcode.hot;

/**
 * 目标和
 */
public class FindTargetSumWays494 {

    /**
     * 给你一个整数数组 nums 和一个整数 target 。
     * <p>
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     * <p>
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     */
    public int findTargetSumWays(int[] nums, int target) {
        // dfs解题
        return dfsHelper(nums, target, 0);
    }

    public int dfsHelper(int[] nums, int target, int index) {
        if (index == nums.length && target == 0) {
            return 1;
        }
        for (int i = index; i < nums.length; i++) {
            return dfsHelper(nums, target - nums[i], index + 1)
                    +
                    dfsHelper(nums, target + nums[i], index + 1);
        }
        return 0;
    }


}
