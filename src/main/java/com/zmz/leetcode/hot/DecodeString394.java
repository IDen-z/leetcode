package com.zmz.leetcode.hot;

import java.util.ArrayDeque;

/**
 * 字符串解码
 */
public class DecodeString394 {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     */
    public String decodeString(String s) {
        // 这道题需要用栈解决
        // 利用两个栈 一个用来记录次数 另一个用来记录字符串
        ArrayDeque<Integer> numQueue = new ArrayDeque<>();
        ArrayDeque<String> stringQueue = new ArrayDeque<>();
        int num = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (isNum(s.charAt(i))) {
                // 如果是数字
                num = num * 10 + Integer.parseInt(s.charAt(i) + "");
            } else if (s.charAt(i) == '[') {
                // 左括号时入栈
                numQueue.add(num);
                num = 0;
                stringQueue.add(res);
                res = "";
            } else if (s.charAt(i) == ']') {
                int times = numQueue.removeLast();
                String preString = stringQueue.removeLast();
                while (times > 0) {
                    preString += res;
                    times--;
                }
                res = preString;
            } else {
                // 普通字符串
                res += s.charAt(i);
            }
        }
        return res;
    }

    /**
     * 是否是数字
     */
    private boolean isNum(char c) {
        return ('0' <= c && '9' >= c);
    }


}
