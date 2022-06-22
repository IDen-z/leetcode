package com.zmz.leetcode.tag.string2;

import java.util.Arrays;
import java.util.List;

/**
 * 最长公共前缀
 */
public class LongestCommonPrefix14 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     */

    public String longestCommonPrefix(String[] strs) {
        // 第一次做没有思路
        // 观察题解后发现第一种思路就是横向扫描

        if (strs.length == 0) {
            return "";
        }

        int n = strs.length;
        // 初始化公共前缀 默认第一个字符串为初始值
        String res = strs[0];
        for (int i = 1; i < n; i++) {
            // 比较当前最大前缀和当前str的交集
            res = comparePrefix(res, strs[i]);
            if (res.length() <= 0) {
                return "";
            }
        }
        return res;

    }

    /**
     * 比较两个字符串的公共前缀
     */
    private String comparePrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }


}
