package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class Insert57 {

    // TODO 未完成

    // 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i]
    // = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals
    // 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
    //
    //在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
    //
    //返回插入之后的 intervals。
    //
    //注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
    //
    //
    //
    //示例 1：
    //
    //输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
    //输出：[[1,5],[6,9]]
    //示例 2：
    //
    //输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    //输出：[[1,2],[3,10],[12,16]]
    //解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1, 5}};
        insert(ints, new int[]{0, 3});
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < intervals.length; i++) {
            // 本身的区间不重叠
            left = intervals[i][0];
            right = intervals[i][1];


            if (newInterval[0] < left || newInterval[0] <= right) {
                // 只有在找到左边界的时候才有必要插入区间
                if (newInterval[0] < left) {
                    left = newInterval[0];
                }
                // 需要融合 左边界已经确定
                // 找到右边界
                while (i + 1 < intervals.length && newInterval[1] >= intervals[i][1]) {
                    i = i + 1;
                }
                if (newInterval[1] >= intervals[i][0] && newInterval[1] >= intervals[i][1]) {
                    right = newInterval[1];
                } else if (newInterval[1] >= intervals[i][0]) {
                    right = intervals[i][1];
                } else {
                    right = newInterval[1];
                    res.add(new int[]{left, right});
                    res.add(intervals[i]);
                    continue;
                }
            }
            res.add(new int[]{left, right});

            // 也有可能完全不重叠
            if (i + 1 < intervals.length && newInterval[0] > right && newInterval[1] < intervals[i + 1][0]) {
                res.add(new int[]{newInterval[0], newInterval[1]});
            } else if (i + 1 == intervals.length && newInterval[0] > right) {
                res.add(new int[]{newInterval[0], newInterval[1]});
            }
        }
        return res.toArray(new int[][]{});
    }

}
