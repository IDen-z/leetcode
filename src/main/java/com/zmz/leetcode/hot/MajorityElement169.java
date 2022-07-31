package com.zmz.leetcode.hot;

import java.util.Arrays;

/**
 * 多数元素
 */
public class MajorityElement169 {

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */
    public int majorityElement(int[] nums) {
        // 找到出现次数 大于 n/2 的元素
        // 排序返回n/2的元素
        Arrays.sort(nums);
        return nums[nums.length/2];

        // 这道题如果为了实现常数级算法复杂度 还可以使用投票法 分治法

    }


}
