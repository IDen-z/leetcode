package com.zmz.leetcode.hot;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 最长连续序列
 */
public class LongestConsecutive128 {

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 第一思路 排序后遍历一边

        // 后面再提交时发现 这样是有问题的
        // 比如 0 1 1 2 如果没有间隔 那么应该continue 跳过当前index
        int res = 1;
        int max = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                res++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                res = 1;
            }
            max = Math.max(max, res);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutive128 longestConsecutive128 = new LongestConsecutive128();
        int i = longestConsecutive128.longestConsecutiveOff(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
    }

    public int longestConsecutiveOff(int[] nums) {
        // 这题的关键在于设计使用On的时间复杂度解决问题
        HashSet<Integer> set = new HashSet<>();
        // 利用一个hash表 去重
        for (int i : nums) {
            set.add(i);
        }
        // 遍历hash表
        int max = 1;
        for (int i : set) {
            if (set.contains(i - 1)) {
                // 如果hash表中存在上个连续子序列 那么跳过
                continue;
            } else {
                // 不存在上个连续子序列 那么就遍历寻找最长子序列长度
                int index = i;
                int res = 1;
                while (set.contains(++index)) {
                    res++;
                }
                max = Math.max(res, max);
            }
        }
        return max;


    }

}
