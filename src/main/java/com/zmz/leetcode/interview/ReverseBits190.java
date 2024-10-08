package com.zmz.leetcode.interview;

public class ReverseBits190 {
    // 颠倒给定的 32 位无符号整数的二进制位。
    //
    //提示：
    //
    //请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
    //在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
    //
    //
    //示例 1：
    //
    //输入：n = 00000010100101000001111010011100
    //输出：964176192 (00111001011110000010100101000000)
    //解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
    //     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
    //示例 2：
    //
    //输入：n = 11111111111111111111111111111101
    //输出：3221225471 (10111111111111111111111111111111)
    //解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
    //     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。

    public static void main(String[] args) {
        reverseBits(-3);
    }

    public static int reverseBits(int n) {
        // 输入的是整形带符号数字
        int res = 0;
        // 循环32次
        for (int i = 0; i < 32; i++) {

            // 获取最低位
            int low = n & 1;
            // 处理一位 n右移一位
            n = n >>> 1;
            // low要左移到翻转后的位置
            int i1 = low << (31 - i);
            res |= i1;
        }
        return res;

    }

    public static int right(int n) {
        // 将整数转换为32位二进制字符串，前面补零
        return Integer.reverse(n);
    }


    public static int reverseBitsOpt(int n) {
        // TODO 这样写是行不通的 因为在32位的中间位进行处理 会同时存在左移和右移两种操作
        // TODO 增加操作难度

        // 最多32位
        int res = 0;
        // 遍历32位处理每一个二进制

        String binaryString = Integer.toBinaryString(n);

        //输入：n = 00000010100101000001111010011100
        //输出：964176192 (00111001011110000010100101000000)
        for (int i = 0; i < 32; i++) {
            // 从低到高获取第i位的十进制的值
            int i1 = n & (1 << i);
            String temp = Integer.toBinaryString(i1);
            // 把十进制的值通过移位到目标位置（从高到底）
            int i2 = i1 << (31 - 2 * i);
            String resSStr1 = Integer.toBinaryString(i2);
            res |= i2;
            String resSStr2 = Integer.toBinaryString(res);
            System.err.println();
        }
        String binaryString1 = Integer.toBinaryString(res);
        return res;
    }

}
