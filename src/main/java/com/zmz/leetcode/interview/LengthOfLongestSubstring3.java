package com.zmz.leetcode.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring3 {

    // 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
    //子串
    // 的长度。
    //
    //
    //
    //示例 1:
    //
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //示例 2:
    //
    //输入: s = "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //示例 3:
    //
    //输入: s = "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

    public static void main(String[] args) {
        lengthOfLongestSubstring_hashMap("abba");
    }

    public int lengthOfLongestSubstring_First(String s) {
        // 存储字符和其最新出现的索引
        int res = 0;
        int index = 0;
        int left = 0;
        int right = 0;
        while (index < s.length()) {
            right = index;
            for (int i = left; i < right; i++) {
                if (s.charAt(i) == s.charAt(index)) {
                    left = i + 1;
                    break;
                }
            }
            index++;
            res = Math.max(res, index - left);
        }
        return res;
    }

    public static int lengthOfLongestSubstring_hashMap(String s) {
        // 使用hashMap 优化 为ON  存储字符和其最新出现的索引
        int res = 0;
        int index = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (index < s.length()) {
            right = index;
            if (map.containsKey(s.charAt(index))) {
                // 使用max是为了防止 left已经移动到后面的指针了
                // 不能再回到前面
                left = Math.max(map.get(s.charAt(index)) + 1, left);
            }
            res = Math.max(res, index - left + 1);
            map.put(s.charAt(index), index);
            index++;
        }
        return res;

    }

    public static int lengthOfLongestSubstringOpt(String s) {
        //滑动窗口
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();//去重
        int res = 0;//结果
        // 外层循环处理右边  内层循环处理左边界
        for (int left = 0, right = 0; right < s.length(); right++) {//每一轮右端点都扩一个。
            char ch = ss[right];//right指向的元素，也是当前要考虑的元素
            while (set.contains(ch)) {//set中有ch，则缩短左边界，同时从set集合出元素
                // 这个remove是关键 注意是吧重复元素左边的所有元素都删除
                set.remove(ss[left]);
                left++;
            }
            set.add(ss[right]);//别忘。将当前元素加入。
            res = Math.max(res, right - left + 1);//计算当前不重复子串的长度。
        }
        return res;
    }
}



