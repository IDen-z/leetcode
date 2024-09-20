package com.zmz.leetcode.interview;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculate224 {

    // 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
    //
    //注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "1 + 1"
    //输出：2
    //示例 2：
    //
    //输入：s = " 2-1 + 2 "
    //输出：3
    //示例 3：
    //
    //输入：s = "(1+(4+5+2)-3)+(6+8)"
    //输出：23

    public int calculate(String s) {
        // 这道题可能有 负数 多位数 需要考虑
        // 这道题其实主要思路是左括号表示需要把result 和 sign存起来开始子表达式的计算
        // 右括号是表示子表达式已经计算完毕 把之前栈中的数字和符号弹出回到正常的计算
        int result = 0;
        // 当前数字 为了应对多位数字所以存在
        int curNum = 0;
        // 记录符号
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            // 处理数字
            if (Character.isDigit(s.charAt(i))) {
                curNum = curNum * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '+') {
                // 加号
                result += sign * curNum;
                curNum = 0;
                sign = 1;
            } else if (s.charAt(i) == '-') {
                // 减号
                result += sign * curNum;
                curNum = 0;
                sign = -1;
            } else if (s.charAt(i) == '(') {
                // 左括号 代表需要把当前result和sign存储起来
                // 为什么需要存储sign是因为这里都是后置处理
                // 比如2+ 就是先处理2 加号跟着后面的数字处理 -号同理
                stack.addLast(result);
                stack.addLast(sign);
                curNum = 0;
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                // 右括号 说明子计算完毕
                result += sign * curNum;
                // 把之前的计算结果累加上来
                result *= stack.removeLast();
                result += stack.removeLast();
                curNum = 0;
                sign = 1;
            }


        }
        // 有可能最后一个是数字
        if (curNum != 0) {
            result += sign * curNum;
        }
        return result;


    }

}
