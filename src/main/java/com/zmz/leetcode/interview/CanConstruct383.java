package com.zmz.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct383 {

    // 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
    //
    //如果可以，返回 true ；否则返回 false 。
    //
    //magazine 中的每个字符只能在 ransomNote 中使用一次。
    //
    //
    //
    //示例 1：
    //
    //输入：ransomNote = "a", magazine = "b"
    //输出：false
    //示例 2：
    //
    //输入：ransomNote = "aa", magazine = "ab"
    //输出：false
    //示例 3：
    //
    //输入：ransomNote = "aa", magazine = "aab"
    //输出：true
    public static void main(String[] args) {
        canConstruct("aa", "aab");
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        // 把存在的字符串放到哈希表中 map
        Map<Character, Integer> strMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            strMap.put(magazine.charAt(i), strMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        int index = 0;
        while (index < ransomNote.length()) {
            if (strMap.containsKey(ransomNote.charAt(index))) {
                if (strMap.get(ransomNote.charAt(index)) <= 0) {
                    return false;
                }
                strMap.put(ransomNote.charAt(index), strMap.get(ransomNote.charAt(index)) - 1);
            } else {
                return false;
            }
            index++;
        }
        return true;
    }

}
