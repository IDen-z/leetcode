package com.zmz.leetcode.interview;

public class LongestCommonPrefix14 {

    // 编写一个函数来查找字符串数组中的最长公共前缀。
    //
    //如果不存在公共前缀，返回空字符串 ""。
    //
    //
    //
    //示例 1：
    //
    //输入：strs = ["flower","flow","flight"]
    //输出："fl"
    //示例 2：
    //
    //输入：strs = ["dog","racecar","car"]
    //输出：""
    //解释：输入不存在公共前缀。

    public String longestCommonPrefix(String[] strs) {
        // 遍历
        if (strs.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            Character c = strs[0].charAt(i);
            sb.append(c);

        }

        return null;
    }


}
