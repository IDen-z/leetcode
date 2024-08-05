package com.zmz.leetcode.interview;

public class Candy135 {

    // n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
    //
    //你需要按照以下要求，给这些孩子分发糖果：
    //
    //每个孩子至少分配到 1 个糖果。
    //相邻两个孩子评分更高的孩子会获得更多的糖果。
    //请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
    //
    //
    //
    //示例 1：
    //
    //输入：ratings = [1,0,2]
    //输出：5
    //解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
    //示例 2：
    //
    //输入：ratings = [1,2,2,1]
    //输出：4
    //解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
    //     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。

    public int candy(int[] ratings) {
        // 相邻的孩子 评分高的要比评分低的多一个糖果
        // 有两种情况 从左至右比起来 和 从右到左比起来
        int res = 0;

        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
            res = res + Math.max(right[i], left[i]);
        }
        // 取两次遍历的最大值  说明既满足左规则 又满足右规则
        return res;


    }


}
