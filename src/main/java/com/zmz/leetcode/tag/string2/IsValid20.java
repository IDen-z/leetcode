package com.zmz.leetcode.tag.string2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 */
public class IsValid20 {


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     */


    public boolean isValid(String s) {
        // 这种写法效率偏低
        // 主要原因是因为我是操作到最后才判断栈是否有值
        // 其实在循环中就可以判断出是否应该跳出循环了

        if (s == null || s.length() == 0) {
            return false;
        }

        // 第一反应就是利用栈的先进后出的特性
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int index = 1;
        while (index < s.length()) {
            if (isMatch(s.charAt(index), stack.peek())) {
                stack.pop();
            } else {
                stack.push(s.charAt(index));
            }
            index++;
        }
        return stack.empty();
    }

    private boolean isMatch(char c, Character peek) {
        if (peek == '(' && c == ')') {
            return true;
        }
        if (peek == '{' && c == '}') {
            return true;
        }
        if (peek == '[' && c == ']') {
            return true;
        }
        return false;
    }

    public boolean isVaildOffcial(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // 第一反应就是利用栈的先进后出的特性
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            if (pairs.containsKey(s.charAt(index))) {
                if (stack.empty() || !stack.peek().equals(pairs.get(s.charAt(index)))) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(index));
            }
            index++;
        }
        return stack.empty();

    }

    Map<Character, Character> pairs = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public static void main(String[] args) {
        IsValid20 isValid20 = new IsValid20();
        boolean valid = isValid20.isValid("(){}");
        System.err.println(valid);
    }


}
