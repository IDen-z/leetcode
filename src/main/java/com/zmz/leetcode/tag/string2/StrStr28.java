package com.zmz.leetcode.tag.string2;

/**
 * 实现strStr函数
 */
public class StrStr28 {

    /**
     * 实现 strStr() 函数。
     * <p>
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
     * <p>
     * 说明：
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
     */

    // 这题还有一个KMP解法 专门用于字符串的匹配查找算法 可以进阶的时候继续了解


    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (!haystack.contains(needle)) {
            return -1;
        }
        // 暴力解法 比较haystack中长度和needle相等的所有字串
        int l = needle.length();
        for (int i = 0; i < haystack.length() - l + 1; i++) {
            // 每一个字串都需要比较
            boolean flag = true;
            for (int j = 0; j < l; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    // 如果不等则直接跳出当前子串的循环
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }
        return -1;

    }


}
