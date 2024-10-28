package com.zmz.leetcode.interview;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs373 {

    // 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
    //
    //定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
    //
    //请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 非递增数组 已经是 平序 升序数组了
        // 和最小的k个数对 必然只能是 00、 01 10（中的最小值） 以此类推
        // 维护一个最小堆 ij 入堆时 如果 i+1,j 和 i,j+1同时入堆
        // 那么会导致重复入堆 比如 01 会导致 02 11 入堆 但是 10 也会导致20 11入堆 11就重复入堆
        // 取数就会重复
        // 解决方案有两个 一个使用hash表
        // 另一个通过初始化 00 10 20 30 ...n0 的堆 通过仅入堆j下标来实现去重（更优）
        List<List<Integer>> res = new ArrayList<>();

        // 最小堆
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // 初始化最小堆
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        // 弹出k个元素
        while (k != 0 && !minHeap.isEmpty()) {
            int[] ints = minHeap.poll();
            res.add(Arrays.asList(nums1[ints[1]], nums2[ints[2]]));

            // 入堆j+1
            if (ints[2] + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[ints[1]] + nums2[ints[2] + 1], ints[1], ints[2] + 1});
            }
            k--;
        }
        return res;
    }


}
