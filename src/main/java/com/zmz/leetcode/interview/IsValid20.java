package com.zmz.leetcode.interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class IsValid20 {
    // 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    //每个右括号都有一个对应的相同类型的左括号。
    //
    //
    //示例 1：
    //
    //输入：s = "()"
    //
    //输出：true
    //
    //示例 2：
    //
    //输入：s = "()[]{}"
    //
    //输出：true
    //
    //示例 3：
    //
    //输入：s = "(]"
    //
    //输出：false
    //
    //示例 4：
    //
    //输入：s = "([])"
    //
    //输出：true
    Map<Character, Character> pairs = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        // 使用栈 模拟
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (deque.isEmpty() || deque.getLast() != map.get(s.charAt(i))) {
                    return false;
                }
                deque.removeLast();
            } else {
                deque.addLast(s.charAt(i));
            }
        }
        return deque.isEmpty();
    }


}
