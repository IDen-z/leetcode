package com.zmz.leetcode.interview;

public class HammingWeight191 {

    // 给定一个正整数 n，编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中
    //设置位的个数（也被称为汉明重量）。

    public int hammingWeight(int n) {
        // 求二进制形式的1的个数
        int res = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >>> 1;
        }
        return res;

    }

    public int hammingWeightOpt(int n) {
        // 求二进制形式的1的个数
        int res = 0;
        // Y优化算法
        // 利用算法  n & (n-1) 相当于去掉最低位的1
        // 题目转换为 n&n-1 执行了几次 就是答案
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;

    }


}
