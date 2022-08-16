package com.zmz.leetcode.hot;

/**
 * 比特位计数
 */
public class CountBits338 {


    /**
     * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
     * 返回一个长度为 n + 1 的数组 ans 作为答案。
     */
    public int[] countBits(int n) {
        // 这种是利用原生方法
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    /**
     * 动态规划方法
     */
    public int[] countBitsOff(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

}
