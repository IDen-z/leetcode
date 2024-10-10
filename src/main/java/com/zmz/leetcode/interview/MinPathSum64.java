package com.zmz.leetcode.interview;

public class MinPathSum64 {

    // 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //
    //说明：每次只能向下或者向右移动一步。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
    //输出：7
    //解释：因为路径 1→3→1→1→1 的总和最小。
    //示例 2：
    //
    //输入：grid = [[1,2,3],[4,5,6]]
    //输出：12

    public static void main(String[] args) {
        MinPathSum64 bean = new MinPathSum64();
        bean.minPathSumOpt(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }

    private int res = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        // DFS求解 超时
        dfsMethod(grid, 0, 0, 0);

        return res;
    }

    private void dfsMethod(int[][] grid, int i, int j, int sum) {
        if (i >= grid.length || j >= grid[0].length) {
            return;
        }
        sum += grid[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            res = Math.min(res, sum);
        }
        dfsMethod(grid, i + 1, j, sum);
        dfsMethod(grid, i, j + 1, sum);

    }


    public int minPathSumOpt(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j > 0) {
                    dp[0][j] = dp[0][j - 1] + grid[i][j];
                } else if (j == 0 && i > 0) {
                    dp[i][0] = dp[i - 1][0] + grid[i][j];
                } else if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }


}
