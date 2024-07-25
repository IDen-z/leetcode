package com.zmz.leetcode.interview;

import java.util.Arrays;

public class MajorityElement169 {

    public static int majorityElement(int[] nums) {
        // 排序 返回中间值

        Arrays.sort(nums);

        return nums[nums.length/2];

    }

    public static int majorityElement2(int[] nums) {
        // 排序 返回中间值
        // 尝试使用空间复杂度O1 时间复杂度On

        // 示例 1：
        //
        //输入：nums = [3,2,3]
        //输出：3
        //示例 2：
        //
        //输入：nums = [2,2,1,1,1,2,2]
        //输出：2

        // 使用随机给一个数字 来验证这个数字是否是众数 计算概率期望为2



        return 0;
    }

}
