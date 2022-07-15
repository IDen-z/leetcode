package com.zmz.leetcode.hot;

/**
 * 不同路径
 */
public class UniquePaths62 {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * <p>
     * 问总共有多少条不同的路径？
     */
    public int uniquePaths(int m, int n) {
        // 这种机器人路径问题第一反应都是用回溯求解
        int res = 0;
        return dfsPaths(m, n, 0, 0, res);
    }

    public int dfsPaths(int m, int n, int i, int j, int res) {
        if (i >= m || j >= n) {
            // 越界则返回
            return res;
        }
        if (i == m - 1 && j == n - 1) {
            res++;
            return res;
        }
        // 既没有越界 又没有到达右下角 继续走路
        res = dfsPaths(m, n, i + 1, j, res);
        res = dfsPaths(m, n, i, j + 1, res);
        return res;
    }

    public static void main(String[] args) {
        UniquePaths62 uniquePaths62 = new UniquePaths62();
        int i = uniquePaths62.uniquePaths(23, 12);
        int j = uniquePaths62.uniquePathsOff(23, 12);
        System.err.println(i);
        System.err.println(j);
    }

    // 后面提交的时候发现超时了
    public int uniquePathsOff(int m, int n) {
        // 利用动态规划的方法
        // 每个dp数组代表以ij单元为终点时的可走路线
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0 && i > 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


}
