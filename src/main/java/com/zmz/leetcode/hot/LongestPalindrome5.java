package com.zmz.leetcode.hot;

/**
 * 最长回文子串
 */
public class LongestPalindrome5 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     */
    public String longestPalindrome(String s) {
        // 动态规划的经典题目 一定收藏再做
        // 这道题的解题思路主要是分三步
        // 1、想明白动态鬼话数组代表的物理意义，dp[i][j]代表的是字符串s
        // 由i开始到j结束的子串，那么 如果 当前字符s[i]==s[j] 那么直接去观察dp[i+1][j-1]即可
        // 2、初始化 二维数组斜对角一定是true 相当于一个字符的子串一定是回文串
        // 3、动态转移方程 也就是改步的结果取决于上一步或上几步
        // 4、考虑边界条件 本题中仅考虑i<j 因为i>j就相当于反过来 没有意义
        int l = s.length();
        int[][] dp = new int[l][l];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        // 二维数组中 0 代表false，1代表true
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        // 这里的遍历方式有点问题 因为要拿dp[i + 1][j - 1]
        // 因此要竖着遍历 不能横着


        for (int j = 1; j < l; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    // 如果字符不相等
                    dp[i][j] = 0;
                } else {
                    if (j - i < 2) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] == 1 && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static void main(String[] args) {
        LongestPalindrome5 longestPalindrome5 = new LongestPalindrome5();
        String bababc = longestPalindrome5.longestPalindrome("bababc");
        System.err.println(bababc);
    }

}
