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
        // 首先想到了暴力揭解法 大概是O(n3)的时间复杂度
        List<List<Integer>> res = new ArrayList<>();
        // 查看题解 发现解题思路主要在于不让结果重复上面
        // 放弃使用数据结构 考虑利用有序数组和指针进行解决问题
        Arrays.sort(nums);
        // 从低向高遍历
        int l = nums.length;
        int index = l - 1;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                index = l - 1;
                while (j != index) {
                    if (nums[i] + nums[j] + nums[index] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[index]);
                        res.add(list);
                        break;
                    } else {
                        index--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum15 threeSum15 = new ThreeSum15();
        threeSum15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

}
