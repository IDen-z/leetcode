package com.zmz.leetcode.hot;

import java.util.*;

/**
 * 字母异味分词
 */
public class GroupAnagrams49 {


    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 异位次排序后应该是一致的
        // 利用排序进行求解
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // 排序后字符串
            String s1 = Arrays.toString(chars);
            if (map.containsKey(s1)) {
                List<String> list = map.get(s1);
                list.add(s);
            } else {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(s);
                map.put(s1, strings);
            }
        }
        return new ArrayList<>(map.values());
    }


}
