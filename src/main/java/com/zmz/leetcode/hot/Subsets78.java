package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class Subsets78 {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 这种题第一反应用dfs
        // 关键在于不重复 不重复的回溯的话需要每次记录回溯的起始位置
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfsSub(nums, 0, 0, res, list);
        res.add(new ArrayList<>());
        return res;
    }

    public void dfsSub(int[] nums, int index, int begin, List<List<Integer>> res, List<Integer> list) {
        if (index == nums.length ) {
            return;
        }
        // dfs算法的关键在于起始位置
        // index用来记录回溯的终点
        // begin用来记录不重复的起始值
        for (int i = begin; i < nums.length; i++) {
            if (list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfsSub(nums, index + 1, i, res, list);
            list.remove(list.size() - 1);
        }
    }


}
