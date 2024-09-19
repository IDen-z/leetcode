package com.zmz.leetcode.interview;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal120 {

    // 给定一个三角形 triangle ，找出自顶向下的最小路径和。
    //
    //每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
    //
    //
    //
    //示例 1：
    //
    //输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    //输出：11
    //解释：如下面简图所示：
    //   2
    //  3 4
    // 6 5 7
    //4 1 8 3
    //自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
    //示例 2：
    //
    //输入：triangle = [[-10]]
    //输出：-10

    public static void main(String[] args) {
        MinimumTotal120 bean = new MinimumTotal120();
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        bean.minimumTotal(list);
    }
    // 使用dfs超出时间限制

    private int res = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        // DFS 获取所有的结果进行比较
        dfsMethod(triangle, 0, 0, 0);
        return res;
    }

    private void dfsMethod(List<List<Integer>> triangle, int i, int count, int sum) {
        if (count > triangle.size() - 1) {
            res = Math.min(res, sum);
            return;
        }
        sum += triangle.get(count).get(i);
        dfsMethod(triangle, i, count + 1, sum);
        sum -= triangle.get(count).get(i);
        if (count != 0) {
            sum += triangle.get(count).get(i + 1);
            dfsMethod(triangle, i + 1, count + 1, sum);
        }
    }

    // TODO 本题目还有更优解 自下而上
    public int minimumTotalDp(List<List<Integer>> triangle) {
        // 创建dp数组
        int n = triangle.size();
        // dp 表示到达当前节点的最小和
        // 那么 dp 就是上一行的i节点 或者 i+1节点 的dp值+当前节点的值
        int[][] dp = new int[n][n];
        // 初始化三角的顶 的值
        // i表示行数 j表示下标
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 最左边只能是j
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    // 最右边只能是j-1
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        // 查找最后一层的最小值
        int minTotal = dp[n - 1][0];
        for (int j = 1; j < n; j++) {
            minTotal = Math.min(minTotal, dp[n - 1][j]);
        }

        return minTotal;

    }


}
