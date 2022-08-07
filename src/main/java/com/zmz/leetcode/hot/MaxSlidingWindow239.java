package com.zmz.leetcode.hot;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindow239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
         * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
         *
         * 返回 滑动窗口中的最大值 。
         *
         */
        // 题解就是给一个数组 给一个窗口的大小 模拟出滑动窗口的最大值 \
        // 提交后发现模拟法会超出时间限制
        if (nums.length < k) {
            return null;
        }
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = k - 1;
        for (int i = 0; i < res.length; i++) {
            int max = nums[left];
            for (int j = left + 1; j <= right; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
            left++;
            right++;
        }
        return res;
    }

    public int[] maxSlidingWindowOff(int[] nums, int k) {
        // 利用空间换时间
        // 优先队列 堆

        return null;
    }

}
