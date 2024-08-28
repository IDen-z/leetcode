package com.zmz.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic205 {

//     给定两个字符串 s 和 t ，判断它们是否是同构的。
//
//    如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
//    每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }


    public boolean isIsomorphic_opt(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // 检查 s 到 t 的映射
            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false; // 如果映射不一致，返回 false
                }
            } else {
                mapST.put(charS, charT); // 建立新的映射
            }

            // 检查 t 到 s 的映射
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false; // 如果映射不一致，返回 false
                }
            } else {
                mapTS.put(charT, charS); // 建立新的映射
            }
        }

        return true;
    }
}
