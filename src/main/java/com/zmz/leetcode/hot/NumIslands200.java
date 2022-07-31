package com.zmz.leetcode.hot;

/**
 * 岛屿数量
 */
public class NumIslands200 {


    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     */
    public int numIslands(char[][] grid) {
        // 岛屿问题 利用dfs回溯
        // 针对二维数组 每个单元格进行遍历 遍历到无法遍历时 岛屿数量加1
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 主循环 在这个循环中进行dfs搜索 每个节点都需要
                if (grid[i][j] == '1') {
                    dfsSearch(i, j, grid);
                    res++;
                }

            }
        }
        return res;


    }

    private void dfsSearch(int i, int j, char[][] grid) {
        // 递归终止条件
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfsSearch(i - 1, j, grid);
        dfsSearch(i, j - 1, grid);
        dfsSearch(i + 1, j, grid);
        dfsSearch(i, j + 1, grid);

    }


}
