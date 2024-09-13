package com.zmz.leetcode.interview;

public class SearchInsert35 {
    // 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //
    //请必须使用时间复杂度为 O(log n) 的算法。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [1,3,5,6], target = 5
    //输出: 2
    //示例 2:
    //
    //输入: nums = [1,3,5,6], target = 2
    //输出: 1
    //示例 3:
    //
    //输入: nums = [1,3,5,6], target = 7
    //输出: 4

    public int searchInsert(int[] nums, int target) {
        // TODO 简单题
        // 有序数组 就可以考虑二分 题目要求Ologn 也是暗示二分
        int l = 0;
        int r = nums.length - 1;
        int res = nums.length;
        // 因此我们可以将两个条件合并得出最后的目标：
        //  「在一个有序数组中找最接近大于等于 target 的下标」。
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] >= target) {
                res = mid;
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return res;

    }

}
