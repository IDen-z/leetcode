package com.zmz.leetcode.hot;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 柱状图中的最大矩形
 */
public class LargestRectangleArea84 {

    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积
     */
    public int largestRectangleArea(int[] heights) {
        // 暴力解法  此解法会超时
        // 计算以每个矩形长度为高度的最大
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {

            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }

            // 找右边最后 1 个大于等于 heights[i] 的索引
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight) {
                right++;
            }

            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;
    }

    public int largestRectangleAreaOff(int[] heights) {
        // 第一次接触单调栈的相关题目
        // 收藏再做
        // 这题的关键就是意识到遍历每个元素为高度的最大矩形面积
        // 暴力解法的问题在于找矩形宽度的过程中又利用了两次遍历

        // 这里利用单调栈的方法 空间换时间
        // 每次矩形右边没有比当前高度更高的柱子时，即高度比栈顶的高度高
        // 此时就可以计算出栈顶柱子为高度的最大矩形面积
        // 需要注意的是  需要默认数组最后有一个高度为-1的柱子
        // 以此保证单调栈中的每个元素都可以出栈
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                // 将下标入栈
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                // 找到了比栈顶元素小的右边界
                // 可以计算宽度
                int m =0 ;
                if (stack.size() == 1) {
                    m = heights[stack.peek()] * (i);
                }else {
                    m = heights[stack.peek()] * (i - stack.peek());
                }
                res = Math.max(m, res);
                stack.pop();
            }
            stack.push(i);
        }
        // 循环结束后需要默认还有一个下标为 数组长度 高度为-1的
        while (!stack.isEmpty()) {
            // 这样只能保证找到 右边最高的
            // 左边的下标是 length - 当前 或者 上个栈下标
            int m = 0;
            if (stack.size() == 1) {
                m = heights[stack.peek()] * (heights.length);
            } else {
                m = heights[stack.peek()] * (heights.length - stack.peek());
            }
            res = Math.max(m, res);
            stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        LargestRectangleArea84 largestRectangleArea84 = new LargestRectangleArea84();
        int i = largestRectangleArea84.largestRectangleAreaOff(new int[]{2, 1, 2});
        System.err.println(i);
    }


    // 上面的off解法中 思路没问题 但是没有解决 数组高度为0的情况
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
