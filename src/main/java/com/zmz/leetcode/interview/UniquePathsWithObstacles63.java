package com.zmz.leetcode.interview;

public class UniquePathsWithObstacles63 {

    // 给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
    //
    //网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
    //
    //返回机器人能够到达右下角的不同路径数量。
    //
    //测试用例保证答案小于等于 2 * 109。

    public static void main(String[] args) {
        uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // DFS 或者动态规划
        // dp[][]数组表示  机器人从初始位置 走到ij位置的走法
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]+1
        // 初始化dp数组
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 如果起点或终点是障碍，直接返回 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }


        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;

        // TODO 第一行第一列的填充也要看上一个状态
        // 填充第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 0) ? dp[0][j - 1] : 0;
        }

        // 填充第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0) ? dp[i - 1][0] : 0;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];

    }


}
