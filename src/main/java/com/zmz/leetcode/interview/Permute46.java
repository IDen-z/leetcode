package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class Permute46 {


    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     * <p>
     * 输入：nums = [1]
     * 输出：[[1]]
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 生成可能的全排列
        // dfs递归

        dfsHelper(nums, new ArrayList<>());

        return res;
    }

    private void dfsHelper(int[] nums, ArrayList<Integer> list) {
        // 递归终止条件
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        // 递归
        // 先循环还是先加入list

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            // 不包含 就把 他加入list
            list.add(nums[i]);
            dfsHelper(nums, list);
            list.remove(list.size() - 1);
        }

    }


}
