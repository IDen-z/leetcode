package com.zmz.leetcode.interview;

public class Rotate189 {

    public void rotate(int[] nums, int k) {

        // 示例 1:
        //
        //输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]
        //解释:
        //向右轮转 1 步: [7,1,2,3,4,5,6]
        //向右轮转 2 步: [6,7,1,2,3,4,5]
        //向右轮转 3 步: [5,6,7,1,2,3,4]
        //示例 2:
        //
        //输入：nums = [-1,-100,3,99], k = 2
        //输出：[3,99,-1,-100]
        //解释:
        //向右轮转 1 步: [99,-1,-100,3]
        //向右轮转 2 步: [3,99,-1,-100]

        //
        k = k % nums.length;

        int[] res = new int[nums.length];
        System.arraycopy(nums, nums.length - k, res, 0, k);
        System.arraycopy(nums, 0, res, k, nums.length - k);
        System.arraycopy(res, 0, nums, 0, nums.length);

    }

    public void rotate2(int[] nums, int k) {
        // 数组反转
        // 序列反转两次 等于原序列
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);

        //输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}
