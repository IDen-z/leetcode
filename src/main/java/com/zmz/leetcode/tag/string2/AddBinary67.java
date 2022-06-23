package com.zmz.leetcode.tag.string2;

/**
 * 二进制求和67
 */
public class AddBinary67 {

    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * <p>
     * 输入为 非空 字符串且只包含数字 1 和 0。
     */
    public String addBinary(String a, String b) {
        // 查看了题解
        // 模拟相加
        // 关键在于要逆转下字符串的顺序 这样就可以在队尾进行追加字符
        // 最后只需要将字符颠倒过来就可以得到答案

        String ar = new StringBuilder(a).reverse().toString();
        String br = new StringBuilder(b).reverse().toString();
        // 不需要补零
        // 从高位开始计算即可
        int length = Math.max(ar.length(), br.length());
        int carry = 0;
        for (int i = 0; i < length; i++){
            carry += i < a.length() ? (a.charAt(i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(i) - '0') : 0;


        }


    }


}
