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
            // 这种写法没有办法解决 ((()))这种的
            dp[i] = dp[i - 1] + ((s.charAt(i) == ')' && s.charAt(i - 1) == '(') ? 1 : 0);
        }
        return dp[l - 1] * 2;
    }

    public int longestValidParenthesesOff(String s) {
        // 上面那种思路的问题在于 对dp数组的物理定义发生了错误
        // 本题需找出最长有效（格式正确且连续）括号子串的长度
        // 那么当结尾出现字符'(' 时 该子串一定是不合法的 dp数组置0
        // 也就是说dp数组应该代表以i字符结尾的子串合法且连续的长度
        // 进而可以根据这个长度计算出上一个'('的下标
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        // 第一反应直接动态规划
        int l = s.length();
        int[] dp = new int[l];
        // 初始化dp数组
        dp[0] = 0;
        for (int i = 1; i < l; i++) {
            if (s.charAt(i) == '(') {
                // 直接赋值=0
                dp[i] = 0;
            } else {
                // 当i字符==')'
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                    res = Math.max(res, dp[i]);
                    continue;
                }
                if (s.charAt(i - 1) == ')') {
                    // 这种情况需要判断上一个是否能和i构成合法括号
                    if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                        // 后面的子串是为了判断之前是否有合法括号子串
                        dp[i] = dp[i - 1] + 2 + (i - 1 - dp[i - 1] - 1 >= 0 ? dp[i - 1 - dp[i - 1] - 1] : 0);
                        res = Math.max(res, dp[i]);
                        continue;
                    }
                }
                dp[i] = 0;
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestValidParentheses32 longestValidParentheses32 = new LongestValidParentheses32();
        longestValidParentheses32.longestValidParenthesesOff("())");
    }


}
