package com.zmz.leetcode.interview;

public class Rotate48 {
    //给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
    //
    //你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。


    // 输入：matrix = [
    //  [1,2,3]        // 观察规律 先斜对角交换顺序  // 再竖着交换规律
    // ,[4,5,6]
    // ,[7,8,9]]

    //输出：[[7,4,1]
    //     ,[8,5,2],
    //      [9,6,3]]

    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(m);
    }

    public static void rotate(int[][] matrix) {
        // 原地操作 先进行对角线的交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 再进行竖着的翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }


    }

}
