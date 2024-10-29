package com.zmz.leetcode.interview;

public class TrailingZeroes172 {
    public static void main(String[] args) {
        method(30);
    }

    // 给定一个整数 n ，返回 n! 结果中尾随零的数量。
    //
    //提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
    public static int trailingZeroes(int n) {
        // 模拟
        int i = n;
        Long mup = 1l;
        while (i != 0) {
            mup *= i;
            i--;
        }
        // 数0
        int res = 0;
        StringBuilder sb = new StringBuilder(String.valueOf(mup)).reverse();
        for (int j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) == '0') {
                res++;
            } else {
                return res;
            }

        }
        return res;

    }
    // 计算 n! 中的尾随零时，生成零的因素是 10，而 10 是由 2 和 5 相乘得到的。在计算 n! 时，因子 2 的数量总是多于因子 5，因此只需计算因子 5 的数量即可。
    //
    //例如，考虑 n = 10：
    //
    //10! = 10 × 9 × 8 × 7 × 6 × 5 × 4 × 3 × 2 × 1
    //2 的因子：10, 8, 6, 4, 2（其中有多个 2），总数为 8。
    //5 的因子：10, 5，总数为 2。
    //因为有 8 个 2 和 2 个 5，最终可以形成 2 个 10（即 2 个尾随零）。所以只需要计算 5 的数量即可。
    public static int method(int n) {
        int count = 0;
        // 计算 5 的倍数数量
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

}
