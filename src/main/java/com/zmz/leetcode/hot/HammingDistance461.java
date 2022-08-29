package com.zmz.leetcode.hot;

/**
 * 汉明距离
 */
public class HammingDistance461 {

    /**
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     * <p>
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
     */
    public int hammingDistance(int x, int y) {
        int r = x ^ y;
        return Integer.bitCount(r);
    }


}
