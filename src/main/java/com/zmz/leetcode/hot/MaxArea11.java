package com.zmz.leetcode.hot;

/**
 * 盛最多水的容器
 */
public class MaxArea11 {

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     */
    public int maxArea(int[] height) {
        // 这道题想到了双指针 但是如何使用双指针并没有思考的很明白
        // 相当于也是通过看了题解 才知道为什么双指针
        int l = height.length;
        int index1 = 0;
        int index2 = l - 1;
        int res = 0;
        while (index1 != index2 && index1 < l && index2 >= 0) {
            // 每次指针移动较小高度的即可
            // 因为每次移动指针都是横 减一 较高高度的指针更有可能有更大的盛水面积
            res = Math.max((index2 - index1) * Math.min(height[index1], height[index2]), res);
            if (height[index1] < height[index2]) {
                index1++;
            } else index2--;
        }
        return res;
    }


}
