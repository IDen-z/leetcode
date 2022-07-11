package com.zmz.leetcode.hot;

import java.util.Arrays;

/**
 * 下一个排列
 */
public class NextPermutation31 {


    /**
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     * <p>
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     * <p>
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     * <p>
     * 必须 原地 修改，只允许使用额外常数空间。
     */
    public void nextPermutation(int[] nums) {
        // 这题第一反应思路是倒序寻找到第一个小于自身值的
        // 当前小于前一位
        for (int i = nums.length - 1; i > 0; i--) {
            // 倒序遍历
            if (nums[i] > nums[i - 1]) {
                // 找到了第一个
                // 先交换位置
                // 这个排序 左闭右开
                Arrays.sort(nums, i, nums.length );
                // 有可能交换的不是最小的  要找到后面数组中最小的进行交换
                for (int j = i; j < nums.length; j++) {
                    // 因为已经排序 找到第一个大于i-1的值进行交换即可
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);

    }

    public static void main(String[] args) {
        NextPermutation31 nextPermutation31 = new NextPermutation31();
        nextPermutation31.nextPermutation(new int[]{1,3,2});

    }


}
