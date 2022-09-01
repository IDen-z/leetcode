package com.zmz.leetcode.hot;

import java.util.Arrays;

/**
 * 最短无序连续子数组
 */
public class FindUnsortedSubarray581 {


    /**
     * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * <p>
     * 请你找出符合题意的 最短 子数组，并输出它的长度。
     */
    public int findUnsortedSubarray(int[] nums) {
        // 排序后 用双指针遍历
        int[] copyNums = nums.clone();
        Arrays.sort(copyNums);
        int begin = 0, end = nums.length - 1;
        // 关键在于找到第一个左侧不等的下标
        while (begin <= end && nums[begin] == copyNums[begin]) {
            begin++;
        }
        while (begin <= end && nums[end] == copyNums[end]) {
            end--;
        }
        return end - begin + 1;
    }


}
