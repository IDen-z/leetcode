package com.zmz.leetcode.hot;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange34 {


    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * <p>
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 利用二分法找到目标值然后进行中心扩散查找
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if (nums[index] == target) {
                // 找到目标值 进行中心扩散
                return findIndex(nums, index, target);
            }
            if (nums[index] > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return new int[]{-1, -1};
    }

    private int[] findIndex(int[] nums, int index, int target) {
        // 向左找出最小下标
        int left = index;
        int right = index;
        // 这种中心扩散的方法最坏的情况 时间复杂度是On 因为有可能一整个数组都是target
        // 所以找下标时也应该用二分 这样复杂度就是log n 了
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right <= nums.length - 1 && nums[right] == target) {
            right++;
        }
        // 向右找出最大下标
        return new int[]{left + 1, right - 1};
    }

    public static void main(String[] args) {
        SearchRange34 searchRange34 = new SearchRange34();
        int[] ints = searchRange34.searchRange(new int[]{1}, 1);
        System.err.println(ints);
    }

}
