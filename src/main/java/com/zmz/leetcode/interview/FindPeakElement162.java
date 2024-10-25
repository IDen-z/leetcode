package com.zmz.leetcode.interview;

public class FindPeakElement162 {

    // 峰值元素是指其值严格大于左右相邻值的元素。
    //
    //给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
    //
    //你可以假设 nums[-1] = nums[n] = -∞ 。
    //
    //你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
    public static void main(String[] args) {
        int peakElement = findPeakElement(new int[]{1, 2});
        System.err.println(peakElement);
    }

    public static int findPeakElement(int[] nums) {
        // log n 的算法复杂度 考虑二分
        // 每次都往高的地方爬 总能找到一个左低 右低的峰值
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int val = nums[mid];
            if (mid - 1 < 0 || mid + 1 > nums.length - 1) {
                return mid;
            }
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


}
