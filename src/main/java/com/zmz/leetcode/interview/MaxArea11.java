package com.zmz.leetcode.interview;

public class MaxArea11 {

    //  给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    //
    //找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    //
    //返回容器可以储存的最大水量。
    //
    //说明：你不能倾斜容器。

    //输入：[1,8,6,2,5,4,8,3,7]

    //输出：49
    //解释：图中垂直线代表输入数组 [1,5,8,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

    public static void main(String[] args) {
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        // 每次移动更小的那根针
        int res = Integer.MIN_VALUE;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;


    }

}
