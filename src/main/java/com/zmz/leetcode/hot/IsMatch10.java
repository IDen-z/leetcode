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
        s = " " + s;
        p = " " + p;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j + 1 <= n && p.charAt(j + 1) == '*') {
                    continue;
                }
                if (p.charAt(j) != '*') {
                    dp[i][j] = (i > 0 && j > 0 && dp[i - 1][j - 1]) && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
                } else {
                    // 当p==*时 有两种可能 0个 或多个
                    dp[i][j] = (j > 1 && dp[i][j - 2]) || (i > 0 && j > 0 && dp[i - 1][j] && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j-1) == '.'));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        IsMatch10 isMatch10 = new IsMatch10();
        isMatch10.isMatch("ab",".*");
    }


}
