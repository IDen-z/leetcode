package com.zmz.leetcode.interview;

public class ProductExceptSelf238 {

    // 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
    //
    //题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
    //
    //请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [1,2,3,4]
    // [1,1,2,6]
    // [24,12,4,1]
    //输出: [24,12,8,6]
    //示例 2:
    //
    //输入: nums = [-1,1,0,-3,3]
    //输出: [0,0,9,0,0]
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        productExceptSelf(a);
    }

    public static int[] productExceptSelf(int[] nums) {
        // 这道题的基本思路是计算出全部的数据和
        // 然后除以数据本身 但是由于数组有0 且不允许除法。
        // 要求On的时间复杂度
        // 开辟两个数组 计算前缀乘积 后缀乘积 进行累加

        int[] preRes = new int[nums.length];
        int[] sufRes = new int[nums.length];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                preRes[i] = 1;
            } else {
                preRes[i] = nums[i - 1] * preRes[i - 1];
            }
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (j == nums.length - 1) {
                sufRes[j] = 1;
            } else {
                sufRes[j] = nums[j + 1] * sufRes[j + 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = preRes[i] * sufRes[i];
        }
        return res;
    }

}
