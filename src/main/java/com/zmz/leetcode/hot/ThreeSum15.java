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
            boolean flag = false;
            for (int j = i + 1; j < l; j++) {
//                if (flag) {
//                    break;
//                }
                if (nums[i] > 0) {
                    break;
                }
                //去重，当起始的值等于前一个元素，那么得到的结果将会和前一次相同
//                if (i > 0 && nums[i] == nums[i - 1]) continue;
                if (nums[j] == nums[j - 1]) continue;
                index = l - 1;
                while (j != index) {
                    if (res.size() != 0 && nums[j] == nums[j - 1]) {
                        break;
                    }
                    if (res.size() != 0 && index < l - 1 && nums[index] == nums[index + 1]) {
                        index--;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[index] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[index]);
                        res.add(list);
                        index--;
//                        flag = true;
                    } else {
                        index--;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 查看了别人的题解有的思路
     */
    public List<List<Integer>> threeSumOff(int[] nums) {
        // 可以先思考  如何找到不重复的二元数组的
        // 再模拟寻找三元数组 其实就相当于 双指针找二元数组的外面加了一层循环而已
        // 关键在于去重
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 内层双指针循环
            int left = i + 1;
            int right = l - 1;
            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                    while (left > 0 && left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right < l - 1 && left < right && nums[right] == nums[right + 1]) {
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


    public static void main(String[] args) {
        ThreeSum15 threeSum15 = new ThreeSum15();
        threeSum15.threeSumOff(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4});
    }

}
