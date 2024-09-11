package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations17 {

    // 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    //
    //给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    //
    //
    //示例 1：
    //
    //输入：digits = "23"
    //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    //示例 2：
    //
    //输入：digits = ""
    //输出：[]
    //示例 3：
    //
    //输入：digits = "2"
    //输出：["a","b","c"]

    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static void main(String[] args) {
        LetterCombinations17 bean = new LetterCombinations17();
        bean.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        // 所有组合 可以用dfs
        StringBuilder sb = new StringBuilder();
        dfsMethod(res, digits, 0, sb);

        return res;

    }

    private void dfsMethod(List<String> res, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String string = map.get(digits.charAt(index));
        for (int i = 0; i < string.length(); i++) {
            sb.append(string.charAt(i));
            dfsMethod(res, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


}
