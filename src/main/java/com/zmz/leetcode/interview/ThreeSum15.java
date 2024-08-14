package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {

    // 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    //
    //注意：答案中不可以包含重复的三元组。
    //
    //
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [-1,0,1,2,-1,-4]
    //输出：[[-1,-1,2],[-1,0,1]]
    //解释：
    //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
    //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
    //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
    //不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
    //注意，输出的顺序和三元组的顺序并不重要。
    //示例 2：
    //
    //输入：nums = [0,1,1]
    //输出：[]
    //解释：唯一可能的三元组和不为 0 。
    //示例 3：
    //
    //输入：nums = [0,0,0]
    //输出：[[0,0,0]]
    //解释：唯一可能的三元组和为 0 。
    public static void main(String[] args) {
        threeSumError(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        //输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]
        // 对数组进行排序
        // 通过双指针以及外层循环进行跳过重复的比较
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    List<Integer> add = new ArrayList<>();
                    add.add(nums[i]);
                    add.add(nums[left]);
                    add.add(nums[right]);
                    res.add(add);
                    left++;
                    right--;
                    while (left > 0 && left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right < nums.length - 1 - 1 && left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return res;


    }


    public static List<List<Integer>> threeSumError(int[] nums) {
//输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]
        // 对数组进行排序
        // 通过双指针以及外层循环进行跳过重复的比较
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 这里先去重 后判断 会把左右指针共同使用重复字段的情况漏掉 这就是案例不过的原因
                while (left + 1 < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (right - 1 > left && nums[right] == nums[right - 1]) {
                    right--;
                }
                if (nums[left] + nums[right] == -nums[i]) {
                    List<Integer> add = new ArrayList<>();
                    add.add(nums[i]);
                    add.add(nums[left]);
                    add.add(nums[right]);
                    res.add(add);
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return res;
    }

}
