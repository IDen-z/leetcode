package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge56 {

    // 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
    // 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
    //
    //
    //
    //示例 1：
    //
    //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //输出：[[1,6],[8,10],[15,18]]
    //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    //示例 2：
    //
    //输入：intervals = [[1,4],[4,5]]
    //输出：[[1,5]]
    //解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 4}, {0, 4}};
        merge(array);
    }

    public static int[][] merge(int[][] intervals) {
        // 先根据左区间开口排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // 排序后开始遍历
        int left;
        int right;
        // 左区间
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            left = intervals[i][0];
            right = intervals[i][1];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= right) {
                // TODO 这里容易出错
                right = Math.max(intervals[i + 1][1], right);
                i = i + 1;
            }
            list.add(new int[]{left, right});

        }

        return list.toArray(new int[list.size()][]);
    }

}
