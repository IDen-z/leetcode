package com.zmz.leetcode.hot;

/**
 * 编辑距离
 */
public class MinDistance72 {


    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     */
    public int minDistance(String word1, String word2) {
        // 这道题作为经典的动态规划题
        // 需要再做巩固
        // 动态规划算法的核心就在于找到dp数组所代表的真实物理意义
        // 这道题中动态数组dp[i][j]代表了word1的以i结尾的字符串
        // 转换成word2中以j结尾的字符串所用的最少操作数
        // 可以分为两个维度讨论
        // 情况一： s1[i] == s2[j]
        // 此时dp[i][j]=i-1,j-1
        // 情况二：不等
        // 此时转换有三种可能
        // 插入 = i,j-1 +1
        // 转换 i-1,j-1 +1
        // 删除 i-1,j +1
        // 那么取这三种情况的最小值即得到了情况二的最小操作数
        int m = word1.length();
        int n = word2.length();
        // 加一是考虑其中s1或者s2有可能为空字符串
        int[][] dp = new int[n + 1][m + 1];
        word1 = " " + word1;
        word2 = " " + word2;
        // 初始化dp数组
        dp[0][0] = 0;
        // 只遍历半个矩阵即可  （这里不能只遍历半个矩阵）
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                    continue;
                }
                if (word1.charAt(j) == word2.charAt(i)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        MinDistance72 minDistance72 = new MinDistance72();
        minDistance72.minDistance("", "a");
    }


}
