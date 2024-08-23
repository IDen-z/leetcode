package com.zmz.leetcode.interview;

public class SetZeroes73 {

    // 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

    public void setZeroes(int[][] matrix) {


        // 因为要使用原地算法所以把第一行和第一列用作标记，如果改行或该列首个
        // 字符为0 表示整行 整列为0
        // 有一种特殊情况需要提前考虑 第一行第一列中出现0 时，需要把整行或整列置为0

        // 该行和该列的标志位
        boolean colFlag = false;
        boolean rowFlag = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                rowFlag = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                colFlag = true;
                break;
            }
        }
        // 将第一行和第一列作为存储地址
        // 从第二行第二列开始循环
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 根据记录进行填充
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 特殊处理首行首列
        if (rowFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

    }

}
