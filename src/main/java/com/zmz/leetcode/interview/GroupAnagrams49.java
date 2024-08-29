package com.zmz.leetcode.interview;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams49 {
    // 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
    //
    //字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
    //
    //
    //
    //示例 1:
    //
    //输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    //示例 2:
    //
    //输入: strs = [""]
    //输出: [[""]]
    //示例 3:
    //
    //输入: strs = ["a"]
    //输出: [["a"]]

    public List<List<String>> groupAnagrams(String[] strs) {
        // 使用hash表 key作为字符串 value作为List<String>
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);

            // TODO 这里可以优化 成getOrDefault
            if (map.containsKey(s)) {
                List<String> strings = map.get(s);
                strings.add(str);
                map.put(s, strings);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }

        res = new ArrayList<>(map.values());

        return res;

    }


}
