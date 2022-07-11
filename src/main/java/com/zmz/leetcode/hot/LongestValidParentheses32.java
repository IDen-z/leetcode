package com.zmz.leetcode.hot;

/**
 * 最长有效括号
 */
public class LongestValidParentheses32 {

    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 第一反应直接动态规划
        int l = s.length();
        int[] dp = new int[l];
        dp[0] = 0;
        for (int i = 1; i < l; i++) {
            // 这种写法没有办法解决 ((()))这种的  可能需要用到栈
            dp[i] = dp[i - 1] + ((s.charAt(i) == ')' && s.charAt(i - 1) == '(') ? 1 : 0);
        }
        return dp[l - 1] * 2;
    }


}
