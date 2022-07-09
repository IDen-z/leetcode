package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class LetterCombinations17 {


    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        // 暴力解法 给一个map然后占位
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        ArrayList<String> res = new ArrayList<>();
        int l = digits.length();

        // 本题是第一次接触到的深度优先搜索题 很常规的搜索算法 值得收藏再做
        dfs(map, 0, digits, new StringBuilder(), res);
        return res;
    }

    void dfs(HashMap<Character, String> map, int index, String str, StringBuilder sb, ArrayList<String> res) {
        // 先判定递归终止条件
        if (index == str.length()) {
            res.add(sb.toString());
            return;
        }
        String s = map.get(str.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(map, index + 1, str, sb, res);
            sb.deleteCharAt(index);
        }
    }


}
