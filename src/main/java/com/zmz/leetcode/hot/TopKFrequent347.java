package com.zmz.leetcode.hot;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前K个高频元素
 */
public class TopKFrequent347 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
     * 你可以按 任意顺序 返回答案。
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 先遍历一遍数组 将数字出现的次数记录下来
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        // 利用优先队列来模拟最大堆
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
        // 等价于
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        // 遍历map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (priorityQueue.size() == k) {
                // 堆中元素已经满足需求 弹出最小的
                if (count > priorityQueue.peek()[1]) {
                    // 并且堆顶的元素小于当前map的count
                    // 代表要代替
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{num, count});
                }
            } else {
                priorityQueue.offer(new int[]{num, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 3, 2, 2};
        TopKFrequent347 topKFrequent347 = new TopKFrequent347();
        int[] ints = topKFrequent347.topKFrequent(nums, 2);
        System.err.println();
    }


}
