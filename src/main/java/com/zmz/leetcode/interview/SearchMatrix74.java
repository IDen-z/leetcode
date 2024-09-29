package com.zmz.leetcode.interview;

public class SearchMatrix74 {
    // 给你一个满足下述两条属性的 m x n 整数矩阵：
    //
    //每行中的整数从左到右按非严格递增顺序排列。
    //每行的第一个整数大于前一行的最后一个整数。
    //给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。

    public boolean searchMatrix(int[][] matrix, int target) {
        // 二分法找到小于或等于的那一行
        int up = 0;
        int down = matrix.length - 1;
        int row = -1;
        while (up <= down) {
            int mid = (up + down) / 2;
            if (target == matrix[mid][0]) {
                return true;
            } else if (target < matrix[mid][0]) {
                down = mid - 1;
            } else {
                // 这里是二分的一个小变化 用来找到最接近且小于target的下标
                row = mid;
                up = mid + 1;
            }
        }
        if (row == -1) {
            return false;
        }

        // 找到当前行 再二分所在行
        int left = 0;
        int right = matrix[row].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == matrix[row][mid]) {
                return true;
            }
            if (target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }


}
