package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 */
public class FindAnagrams438 {

    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * <p>
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 该题利用滑动窗口和 26个数组(异位词的字母是固定的 因此可以用长度为26的数组确定)
        // 通过这两个数组来记录字符的的个数 来判断两个字符是否是异位词
        int[] s1 = new int[26];
        int[] p1 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            // 把p字符串记录进去
            p1[p.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            s1[s.charAt(r) - 'a']++;
            if (r - l + 1 > p.length()) {
                // 窗口左侧左移
                s1[s.charAt(l++) - 'a']--;
            }
            if (r - l + 1 == p.length() && isSame(s1, p1)) {
                res.add(l);
            }
        }
        return res;
    }

    private boolean isSame(int[] s1, int[] p1) {
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != p1[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAnagrams438 findAnagrams438 = new FindAnagrams438();
        findAnagrams438.findAnagrams("cbaebabacd","abc");



    }

}
