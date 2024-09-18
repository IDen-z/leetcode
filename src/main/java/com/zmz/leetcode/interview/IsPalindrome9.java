package com.zmz.leetcode.interview;

public class IsPalindrome9 {

    //给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    //
    //回文数
    //是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    //
    //例如，121 是回文，而 123 不是。
    //
    //
    //示例 1：
    //
    //输入：x = 121
    //输出：true
    //示例 2：
    //
    //输入：x = -121
    //输出：false
    //解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    //示例 3：
    //
    //输入：x = 10
    //输出：false
    //解释：从右向左读, 为 01 。因此它不是一个回文数。

    public boolean isPalindrome(int x) {
        // 转成字符串
        // 判断是否是回文串
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;


    }

    // 翻转字符串是简单做法
    // 本题的本意是不创建字符串来进行问题的解决
    public boolean isPalindrome2(int x) {
        // 负数和以0结尾的数字都不是回文数字
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 把末尾的数字翻转一半出来
        // 判断翻转一半的数字和剩下的数字大小是否相等
        int reverseHalf = 0;
        while (x > reverseHalf) {
            // 这个while判断是关键
            // 在循环中，我们逐步从 x 中提取最低位，并将其附加到 reversedHalf 中。这个过程中，x 的数字不断减少，而 reversedHalf 不断增加。当 reversedHalf 的长度（位数）等于或超过 x 的时候，就说明我们已经处理了原数字的一半（或一半以上）。
            reverseHalf = x % 10 + reverseHalf * 10;
            x /= 10;

        }
        if (reverseHalf == x || x == reverseHalf / 10) {
            return true;
        }
        return false;

    }


}
