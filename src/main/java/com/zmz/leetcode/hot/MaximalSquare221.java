package com.zmz.leetcode.hot;


/**
 * 最大正方形
 */
public class MaximalSquare221 {


    /**
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     */
    public int maximalSquare(char[][] matrix) {
        // 这道题看了题解
        // 利用了 动态规划
        // 最重要的是要明白动态规划每个矩阵所代表的意义
        // 该题中dp[i][j]代表了当前值作为右下角的最大正方形的边长
        // 注意 这里使用了边长导致可以更好的使用动态规划算法
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        // 初始化dp数组
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
                // 这里不需判断0的情况
                // 因为动态规划的是边长 如果是0  正方形的边长一定是0
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        MaximalSquare221 maximalSquare221 = new MaximalSquare221();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}
        };
        int i = maximalSquare221.maximalSquare(matrix);
        System.err.println(i);


    }


}
