package com.zmz.leetcode.top;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoSum1 {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     */
    public int[] twoSum(int[] nums, int target) {
        // 只需要返回数组下标
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 遍历该数组
            if (map.containsKey(target - nums[i])) {
                // 如果map中包含该数字
                // 说明上次遍历中已经将上个数字存入了
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            // 不包含说明没有 那么把当前的数字存入map即可
            map.put(nums[i], i);
        }
        return res;
    }

}
