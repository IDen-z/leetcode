package com.zmz.leetcode.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    // 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    //
    //你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
    //
    //你可以按任意顺序返回答案。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,7,11,15], target = 9
    //输出：[0,1]
    //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    //示例 2：
    //
    //输入：nums = [3,2,4], target = 6
    //输出：[1,2]
    //示例 3：
    //
    //输入：nums = [3,3], target = 6
    //输出：[0,1]

    public int[] twoSum(int[] nums, int target) {
        // 不能用排序 因为排序会导致下标发生变化
//        Arrays.sort(nums);
//        // 双指针
//        int left = 0;
//        int right = nums.length - 1;
//        while (left < right) {
//            if (nums[left] + nums[right] == target) {
//                return new int[]{left, right};
//            }
//            if (nums[left] + nums[right] < target) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//        return new int[]{};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};


    }

}
