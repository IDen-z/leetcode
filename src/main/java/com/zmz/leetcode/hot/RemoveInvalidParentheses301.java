package com.zmz.leetcode.hot;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 删除无效的括号
 */
public class RemoveInvalidParentheses301 {

    /**
     * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
     * <p>
     * 返回所有可能的结果。答案可以按 任意顺序 返回。
     */
    private List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        // 删除多余括号
        // 这道题看题目描述可以联想到回溯算法
        // 但是回溯之前 需要知道最小删除多少个左括号和右括号
        int lr = 0;
        int rr = 0;
        for (int i = 0; i < s.length(); i++) {
            // 计算需要删除多少个左括号右括号 只需要计算左括号的总数和右括号的总数 保持相等
            if (s.charAt(i) == '(') {
                lr++;
                continue;
            }
            if (s.charAt(i) == ')') {
                // 如果遍历到右括号 且左括号数量大于0 那么可抵消
                if (lr > 0) {
                    lr--;
                } else {
                    rr++;
                }
            }
        }
        // 统计完最小删除的左右括号的数量 进行回溯
        dfsHelper(lr, rr, 0, s);
        return res;
    }

    /**
     * 回溯
     */
    private void dfsHelper(int lr, int rr, int start, String s) {
        if (lr == 0 && rr == 0 && isVaild(s)) {
            // 回溯到lr rr 为0即可 若括号有效 加入res结果集
            res.add(s);
        }
        // 遍历继续回溯
        // 这里一定要从start开始遍历 否则会有很多重复回溯结果
        for (int i = start; i < s.length(); i++) {
            // 当上一个字符和下一个字符相等时 可以跳过
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) == '(') {
                // 这里的start位置不需要加1  是因为 s的长度 已经剪掉了
                dfsHelper(lr - 1, rr, i, s.substring(0, i) + s.substring(i + 1));
            }
            if (s.charAt(i) == ')') {
                dfsHelper(lr, rr - 1, i, s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    /**
     * 验证字符串括号有效性
     */
    private boolean isVaild(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.addLast(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == ')') {
                if (deque.isEmpty()) {
                    return false;
                }
                deque.removeLast();
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses301 removeInvalidParentheses301 = new RemoveInvalidParentheses301();
        List<String> list = removeInvalidParentheses301.removeInvalidParentheses("(a)()))()");
        System.err.println("");
    }


}
