package com.zmz.leetcode.hot;

import com.zmz.leetcode.tag.string2.LengthOfLastWord58;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring3 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    public int lengthOfLongestSubstring(String s) {
        // 暴力解法
        // 这种解法简直可怕 速度很慢 内存占用也很大
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 初始化结果数组
        int[] res = new int[s.length()];
        int index = 1;
        int max = 1;
        int cur = 1;
        StringBuilder sb = new StringBuilder(s.substring(0, 1));
        while (index < s.length()) {
            if (!sb.toString().contains(String.valueOf(s.charAt(index)))) {
                sb.append(s.charAt(index));
                cur++;
            } else {
                // 这里需要找到重复子串的下一个位置
                int i = sb.toString().indexOf(s.charAt(index));
                if (sb.length() == 1) {
                    sb = new StringBuilder(String.valueOf(s.charAt(index)));
                } else {
                    sb = new StringBuilder(sb.toString().substring(i + 1));
                    sb.append(s.charAt(index));
                }
                cur = sb.length();
            }
            max = Math.max(cur, max);
            index++;
        }
        return max;
    }

    // 学习官方解法
    public int lengthOfLongestSubstringOff(String s) {
        // 官方题解推荐使用滑动窗口

        // 其实滑动窗口在感觉上非常类似一个双指针

        // 这题主要还是需要一个数据结构 利用set来进行去重 代码逻辑更加复杂
        // 如果用map可以将字符位置也存进去 省下一次遍历
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;

    }

    public static void main(String[] args) {
        LengthOfLongestSubstring3 lengthOfLongestSubstring3 = new LengthOfLongestSubstring3();
        lengthOfLongestSubstring3.lengthOfLongestSubstringOff("abba");

    }

}
