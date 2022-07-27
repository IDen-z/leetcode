package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 */
public class WordBreak139 {

    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     * <p>
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 这道题利用动态规划
        // dp[i]表示字符串s中第i个字符结尾的字符 能否通过字典拼接
        // 这个题的需要在前面拼接一个空字符 既解决边际问题 又解决了dp数组初始化的问题
        if (s == null || s.length() == 0) return false;
        s = ' ' + s;
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j > 0; j--) {
                // 分割字符  判断j --- i 这部分的字符是否在字典中
                // 这里要注意左闭右开 右边的要+1
                if (dp[j - 1] && wordDict.contains(s.substring(j, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        WordBreak139 wordBreak139 = new WordBreak139();
        wordBreak139.wordBreak("leetcode", Arrays.asList("leet", "code"));
    }

}
