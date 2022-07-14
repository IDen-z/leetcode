package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
 */
public class MergeInterval56 {

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 看题解 对数组左端点进行排序
        // java的arrays没有办法直接对二维数组进行排序
        // 需要手动改动排序规则
        Arrays.sort(intervals, Comparator.comparingInt(item -> item[0]));
        // 只要遍历一次即可 两种情况进行分析
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = list.get(list.size() - 1);
            // 情况一 左端点大于右端点
            if (ints[1] < intervals[i][0]) {
                // 直接加入list
                list.add(intervals[i]);
            } else if (ints[1] >= intervals[i][0]) {
                // 第二种情况 左端点小于右端点
                // 取右端点中较大值
                int[] t = new int[2];
                t[0] = ints[0];
                t[1] = Math.max(ints[1], intervals[i][1]);
                list.remove(list.get(list.size() - 1));
                list.add(t);
            }
        }
        return list.toArray(new int[list.size()][]);
    }


}
