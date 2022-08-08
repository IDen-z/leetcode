package com.zmz.leetcode.hot;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindow239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
         * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
         *
         * 返回 滑动窗口中的最大值 。
         *
         */
        // 题解就是给一个数组 给一个窗口的大小 模拟出滑动窗口的最大值 \
        // 提交后发现模拟法会超出时间限制
        if (nums.length < k) {
            return null;
        }
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = k - 1;
        for (int i = 0; i < res.length; i++) {
            int max = nums[left];
            for (int j = left + 1; j <= right; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
            left++;
            right++;
        }
        return res;
    }

    public int[] maxSlidingWindowOff(int[] nums, int k) {
        // 困难难度的这道题 考察的思路是在On的时间复杂度下
        // 进行解决
        // 利用空间换时间
        // 优先队列 堆
        // 更像是采用了双向队列的操作
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {//注意：此处是小于号
                // 这个循环的目的在于将目前队列中存在的 但是比nums[i]小的值全部移除队列
                // 就像篮球队长选举
                // 比nums[i]还小的数字 已经不可能是滑动窗口的最大值了
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (i >= k && nums[i - k] == deque.peekFirst()) {
                // 如果双向队列的左侧头部的最大值已经划出了窗口
                // 那么需要将其移除
                deque.removeFirst();
            }
            if (i >= k - 1) {
                // 满足条件后 没滑动一次 需要记录下结果集
                res[i - k + 1] = deque.peekFirst();
            }
        }
        return res;
    }

}


