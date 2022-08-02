package com.zmz.leetcode.hot;

import java.util.*;

/**
 * 数组中的第K个最大元素
 */
public class FindKthLargest215 {

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * <p>
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     */
    public int findKthLargest(int[] nums, int k) {
        // 排序后 倒数
        Arrays.sort(nums);
        return nums.length - k >= 0 ? nums[nums.length - k] : 0;
    }

    public int findKthLargestOff(int[] nums, int k) {
        // 采用优先队列
        int length = nums.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.comparing(item -> item));
        // 初始化k个元素的优先队列
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(nums[i]);
        }
        for (int i = k; i < length; i++) {
            Integer peek = priorityQueue.peek();
            // 如果优先队列最顶端的元素小于当期数组中的元素
            if (nums[i] > peek) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        return priorityQueue.peek();

    }


}
