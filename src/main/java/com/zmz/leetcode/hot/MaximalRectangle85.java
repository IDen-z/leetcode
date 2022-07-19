package com.zmz.leetcode.hot;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最大矩形
 */
public class MaximalRectangle85 {

    /**
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     */
    public int maximalRectangle(char[][] matrix) {
        // 这道题完全没有思路
        // 看了题解才发现 这完全就是上一道题 的复用 循环i行调用84的解法就可以了
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            // 计算每层连续的高度
            int[] nums = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++) {
                int count = 0;
                int index = i;
                while (index >= 0 && matrix[index][j] == '1') {
                    index--;
                    count++;
                }
                nums[j] = count;
            }
            res = Math.max(this.largestRectangleAreaOther(nums), res);
        }
        return res;
    }


    public int largestRectangleAreaOther(int[] heights) {
        // 通过左右加一个0高度的柱形 来方便写法
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                res = Math.max(res, (r - l - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }


}
