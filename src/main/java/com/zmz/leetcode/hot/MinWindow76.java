package com.zmz.leetcode.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖字串
 */
public class MinWindow76 {

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * <p>
     *  
     * <p>
     * 注意：
     * <p>
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *  
     */
    public String minWindow(String s, String t) {
        // 这道题需要用到滑动窗口 标记下收藏再练
        // 其实就是双指针遍历
        // 一个记录字符起始位置
        // 一个记录字符终止位置
        // 关键在于需要两个空间来记录t s中的现存字符 通过字符数量比较来确定最小窗口
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> mapS = new HashMap<>();
        // 初始化窗口起始位置
        int l = 0;
        int r = 0;
        int count = 0;
        String res = "";
        int len = Integer.MAX_VALUE;
        while (r < s.length()) {
            mapS.put(s.charAt(r), mapS.getOrDefault(s.charAt(r), 0) + 1);
            if (mapT.containsKey(s.charAt(r)) && mapS.get(s.charAt(r)) <= mapT.get(s.charAt(r))) {
                // count 表示必要字符数量
                count++;
            }
            // 左指针移动删除冗余代码
            // 如果左边界的值不在ht表中 或者 它在hs表中的出现次数多于ht表中的出现次数
            while (l < r && (!mapT.containsKey(s.charAt(l)) || mapS.get(s.charAt(l)) > mapT.get(s.charAt(l)))) {
                mapS.put(s.charAt(l), mapS.get(s.charAt(l)) - 1);
                l++;
            }
            if (count == t.length()) {
                // 当必要字符数量等于t的长度时
                // 说明此时窗口已经包含了所有字符
                // 比较res
                String temp = s.substring(l, r + 1);
                if (temp.length() < len) {
                    res = temp;
                    len = res.length();
                }
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        MinWindow76 minWindow76 = new MinWindow76();
        minWindow76.minWindow("a", "b");
    }

}
