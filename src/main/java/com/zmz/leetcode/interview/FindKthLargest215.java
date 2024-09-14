package com.zmz.leetcode.interview;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest215 {
    // 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    //
    //请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    //
    //你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
    //
    //
    //
    //示例 1:
    //
    //输入: [3,2,1,5,6,4], k = 2
    //输出: 5
    //示例 2:
    //
    //输入: [3,2,3,1,2,4,5,5,6], k = 4
    //输出: 4

    // 方法一的优点是代码简单，直接遍历整个数组，每次插入堆后移除多余的元素，缺点是它的堆操作较多。
    //方法二通过先初始化堆，再选择性地更新堆，减少了不必要的堆操作，使得它的性能在某些情况下更优。
    //两种方法的时间复杂度都是 O(n log k)，但在元素较多时，方法二的优化可以减少堆操作的次数，效率可能稍微高一些。
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        // java的优先队列就是一个最小堆结构
        for (int i = 0; i < nums.length; i++) {
            // 把nums的数据都放在最小堆里
            priorityQueue.offer(nums[i]);
            // 当堆的size到达k时
            if (priorityQueue.size() > k) {
                // 要求出 数组中第 k 个最大的元素 （升序 倒着数第k个元素）
                // 移除最小的
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();


    }

    public int findKthLargestOff2(int[] nums, int k) {
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
