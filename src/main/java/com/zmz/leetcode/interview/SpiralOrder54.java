package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder54 {

    // 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        // 左边界
        int l = 0;
        // 上边界
        int u = 0;
        // 右边界
        int r = matrix[0].length - 1;
        // 下边界
        int d = matrix.length - 1;

        while (true) {
            // 先从左到右
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            // 从左到右遍历后 因为马上要开始从上到下的遍历了(其他值没有变化左右下边界不变)
            // 上边界扩散  不能大于等于 因为等于的时候边界值话没有被统计
            if (++u > d) {
                break;
            }
            // 上到下遍历
            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            // 上到下遍历结束紧接着要从右到左 也就是右边界需要变动
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res.add(matrix[d][i]);
            }
            // 右到左遍历完要下到上了
            if (--d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                res.add(matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }
        return res;


    }

}
