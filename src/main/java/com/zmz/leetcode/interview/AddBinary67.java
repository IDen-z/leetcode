package com.zmz.leetcode.interview;

public class AddBinary67 {

    //给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
    //
    //
    //
    //示例 1：
    //
    //输入:a = "11", b = "1"
    //输出："100"
    //示例 2：
    //
    //输入：a = "1010", b = "1011"
    //输出："10101"
    //

    public static void main(String[] args) {
        addBinary("1", "11");
    }

    public static String addBinary(String a, String b) {
        // 二进制加法求和
        // 模拟列竖式的方式进行求解
        // 从后往前加减
        // 同时使用一个变量记录进位的值
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        // 倒着加
        while (i >= 0 || j >= 0) {

            int sum = 0;
            sum += carry;
            if (i >= 0) {
                // 这里是十进制加减法
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            // 转换成二进制
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

}
