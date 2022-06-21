package com.zmz.leetcode.tag.array1;

import javax.security.auth.login.CredentialException;

/**
 * 加一
 */
public class PlusOne66 {

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */


    public int[] plusOneErr(int[] digits) {
        // 这是最朴实的想法
        // 但是这是错误的 因为如果是99
        // 那么数组的长度应该是比原数组长的
        // 这种写法只能针对最高位不溢出的情况

        // 动态规划
        int n = digits.length;
        int[] res = new int[n];
        int last = digits[n - 1] + 1;
        if (last >= 10) {
            res[n - 1] = 0;
        } else {
            res[n - 1] = last;
        }
        // 倒序遍历
        for (int i = digits.length - 1; i > 0; i--) {
            if (res[i] == 0) {
                res[i - 1] = digits[i - 1] + 1;
            } else {
                res[i - 1] = digits[i - 1];
            }
        }
        return res;
    }

    public int[] plusOne(int[] digits) {
        // 倒序 查找有多少个连续的9
        int index = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                index = i;
                continue;
            } else {
                break;
            }
        }
        // index就是最后一个9的位置
        if (index == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else if (index == -1) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        } else {
            digits[index - 1] = digits[index - 1] + 1;
            for (int i = index; i <= digits.length - 1; i++) {
                digits[i] = 0;
            }
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9};
        PlusOne66 plusOne66 = new PlusOne66();
        int[] ints = plusOne66.plusOne(digits);
        for (int i : ints) {
            System.err.println(i);
        }
    }


}
