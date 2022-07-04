package com.zmz.leetcode.hot;

/**
 * 正则表达式匹配
 */
public class IsMatch10 {

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     */
    public boolean isMatch(String s, String p) {
        // 使用动态规划进行求解 这题也要收藏再做
        // 利用dp[i][j]表示s的前i个字符 是否与p的前j个字符相匹配
        // 初始化数组
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j =1;j<=n;j++){


            }


        }

        return false;
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}
