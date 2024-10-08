package com.zmz.leetcode.interview;

public class PlusOne66 {

    // 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
    //
    //最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
    //
    //你可以假设除了整数 0 之外，这个整数不会以零开头。
    //
    //
    //
    //示例 1：
    //
    //输入：digits = [1,2,3]
    //输出：[1,2,4]
    //解释：输入数组表示数字 123。
    //示例 2：
    //
    //输入：digits = [4,3,2,1]
    //输出：[4,3,2,2]
    //解释：输入数组表示数字 4321。
    //示例 3：
    //
    //输入：digits = [0]
    //输出：[1]
    public static void main(String[] args) {
        plusOne2(new int[]{9,9});
    }

    public static int[] plusOne(int[] digits) {
        Integer carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int n = i == digits.length - 1 ? digits[i] + 1 + carry : digits[i] + carry;
            digits[i] = n % 10;
            carry = n / 10;
        }
        if (carry == 0) {
            return digits;
        }
        int[] ints = new int[digits.length + 1];
        System.arraycopy(digits, 0, ints, 1, digits.length);
        ints[0] = 1;
        return ints;
    }

    public static int[] plusOne2(int[] digits) {
        // TODO 妙啊 最简洁的解法
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


}
