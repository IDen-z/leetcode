package com.zmz.leetcode.interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ReverseWords151 {

    // 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
    //
    //单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
    //
    //返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
    //
    //注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "the sky is blue"
    //输出："blue is sky the"
    //示例 2：
    //
    //输入：s = "  hello world  "
    //输出："world hello"
    //解释：反转后的字符串中不能存在前导空格和尾随空格。
    //示例 3：
    //
    //输入：s = "a good   example"
    //输出："example good a"
    //解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。

    public static String reverseWords(String s) {
        // 两种思路
        // 一种用双端队列

        // 一种用双指针来记录 首尾指针来存一个单词

        if (s.isEmpty()) {
            return "";
        }
        // 去除首尾指针
        s = ' ' + s;
        // 定义左指针，对左指针进行遍历
        int left = s.length() - 1;
        int right = s.length();
        StringBuilder sb = new StringBuilder();
        while (left >= 0) {
            if (s.charAt(left) == ' ') {
                if (left + 1 < right) {    // 防止连续空格的情况
                    sb.append(s, left + 1, right);
                    sb.append(' ');
                }
                right = left;
            }
            left--;
        }
        return sb.substring(0, sb.length() - 1);


    }

    public static String reverseWords2(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int left = 0;
        while (s.charAt(left) == ' ') {
            left++;
        }
        // 定义一个双端队列
        Deque<String> queue = new ArrayDeque<String>();
        StringBuilder sb = new StringBuilder();
        while (left < s.length()) {
            if (s.charAt(left) != ' ') {
                sb.append(s.charAt(left));
            } else if (sb.length() != 0 && s.charAt(left) == ' ') {
                queue.offerFirst(sb.toString());
                sb.setLength(0);
            }
            left++;
        }
        // 把最后一个单词加入
        queue.offerFirst(sb.toString());

        return String.join(" ", queue);


    }


}
