package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 三数之和
 */
public class ThreeSum15 {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 首先想到了暴力揭解法 大概是O(n2)的时间复杂度
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i,nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsValue(-nums[i] - nums[j])) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.add(nums[j]);
                    arrayList.add(-nums[i] - nums[j]);
                    if (map.containsValue(nums[i]) && map.containsValue(nums[j]) && !map.containsKey(map.get(nums[i]) + map.get(nums[j]) + map.get(-nums[i] - nums[j]))) {
                        res.add(arrayList);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum15 threeSum15 = new ThreeSum15();
        threeSum15.threeSum(new int[]{-1,0,1,2,-1,-4});

    }

}
