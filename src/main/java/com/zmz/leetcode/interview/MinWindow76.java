package com.zmz.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class MinWindow76 {

    // 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
    // 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    //
    //
    //
    //注意：
    //
    //对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    //如果 s 中存在这样的子串，我们保证它是唯一的答案。
    //
    //
    //示例 1：
    //"ADABCCOBANC"
    //输入：s = "ADOBECODEBANC", t = "ABC"
    //输出："BANC"
    //解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
    //示例 2：
    //
    //输入：s = "a", t = "a"
    //输出："a"
    //解释：整个字符串 s 是最小覆盖子串。
    //示例 3:
    //
    //输入: s = "a", t = "aa"
    //输出: ""
    //解释: t 中两个字符 'a' 均应包含在 s 的子串中，
    //因此没有符合条件的子字符串，返回空字符串。
    //
    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }

    public static String minWindow(String s, String t) {
        String res = "";
        // 遍历目标字符串t 记录在字符的数量记录在hash表中
        int wordLength = t.length();
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < wordLength; i++) {
            charMap.put(t.charAt(i), charMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 当wordLength == count 时 说明窗口此时记录了满足提议的字符串，记录下来
        Map<Character, Integer> currentMap = new HashMap<>();
        int count = 0;
        //  最小长度
        int minLen = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < s.length(); right++) {
            // 当非t中字符时，右指针移动，左指针不动
            if (!charMap.containsKey(s.charAt(right))) {
                continue;
            } else {
                // 该字符存在于hash表中
                if (currentMap.getOrDefault(s.charAt(right), 0) < charMap.get(s.charAt(right))) {
                    // 字符有用 且数量小于必须数量时 才进行有效字符计数
                    // 多的匹配字符都不计数
                    count++;
                }
                // 和上面那步的顺序需要注意
                currentMap.put(s.charAt(right), currentMap.getOrDefault(s.charAt(right), 0) + 1);

                // 把多余的重复字符移除
                // 多余字符指的是左指针不在目标hash表 或者 大于目标hash表次数的字符
                while (left < right && (
                        !charMap.containsKey(s.charAt(left)) || currentMap.getOrDefault(s.charAt(left), 0) > charMap.get(s.charAt(left))
                )) {
                    if (currentMap.containsKey(s.charAt(left))) {
                        currentMap.put(s.charAt(left), currentMap.get(s.charAt(left)) - 1);
                    }
                    // map -1
                    left++;
                }
                // 如果左指针移动后，count数量整好为目标数量
                if (count == wordLength) {
                    // 截取字符串
                    String substring = s.substring(left, right + 1);
                    if (substring.length() < minLen) {
                        res = substring;
                        minLen = substring.length();
                    }

                }

            }


        }


        return res;
    }


}
