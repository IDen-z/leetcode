package com.zmz.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    // 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
    //
    //这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。

    public boolean wordPattern(String pattern, String s) {
        // 双向链接
        Map<Character, String> cMap = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();
        String[] strings = s.split(" ");

        if (strings.length!=pattern.length()){
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (cMap.containsKey(pattern.charAt(i))) {
                if (!cMap.get(pattern.charAt(i)).equals(strings[i])) {
                    return false;
                }
            } else {
                cMap.put(pattern.charAt(i), strings[i]);
            }

            if (strMap.containsKey(strings[i])) {
                if (strMap.get(strings[i]) != pattern.charAt(i)) {
                    return false;
                }
            } else {
                strMap.put(strings[i], pattern.charAt(i));
            }

        }
        return true;
    }

}
