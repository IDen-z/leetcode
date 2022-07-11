package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class GenerateParenthesis22 {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    public List<String> generateParenthesis(int n) {
        // 暴力回溯解决
        List<String> res = new ArrayList<>();
        generateDfs(n, new StringBuilder(), res);
        return res;
    }

    public void generateDfs(int n, StringBuilder sb, List<String> res) {
        if (sb.length() == 2 * n) {
            // 回溯条件终止
            // 这题的优化点在于在判断回溯终止条件前 只要括号位置不对 就取消掉
            if (vaild(sb.toString())) {
                res.add(sb.toString());
            }
        } else {
            // 长度不够 继续回溯
            sb.append('(');
            generateDfs(n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            generateDfs(n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    private boolean vaild(String str) {
        char[] chars = str.toCharArray();
        int balance = 0;
        for (char c : chars) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        GenerateParenthesis22 generateParenthesis22 = new GenerateParenthesis22();
        generateParenthesis22.generateParenthesis(1);
    }

}
