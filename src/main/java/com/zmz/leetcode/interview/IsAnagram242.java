package com.zmz.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram242 {

    // 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    //
    //字母异位词 是通过重新排列不同单词或短语的字母而形成的单词或短语，通常只使用所有原始字母一次。
    //
    //
    //
    //示例 1:
    //
    //输入: s = "anagram", t = "nagaram"
    //输出: true
    //示例 2:
    //
    //输入: s = "rat", t = "car"
    //输出: false
    //

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                return false;
            }
            if (map.get(s.charAt(i)) <= 0) {
                return false;
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }

        return true;
    }

}
