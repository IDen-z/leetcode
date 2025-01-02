package com.zmz.leetcode.interview;

public class MySqrt69 {

    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * <p>
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * <p>
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 4
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     */
    public static void main(String[] args) {
        MySqrt69 bean = new MySqrt69();
        bean.mySqrt2(6);
    }

    // 这种解法会超时
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int res = x - 1;
        while (res > x / res) {
            res--;
        }
        return res;

    }

    // 采用二分查找的方式
    public int mySqrt2(int x) {
        if (x <= 1) {
            return x;
        }
        // 官方题解 其实可以理解成 x*x <= k 找到第一个x就是正确答案
        // 采用二分的方式
        int left = 1;
        int right = x - 1;
        int res = -1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                // 找到最接近的mid
                res = mid;
                left = mid + 1;
            }
        }
        return res;

    }


}
