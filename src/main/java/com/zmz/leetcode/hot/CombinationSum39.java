package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 */
public class CombinationSum39 {

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * <p>
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
     * <p>
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 这道题没有思路
        // 需要收藏重做
        // 这种搜索考虑使用回溯算法 其实这种尝试型算法都可以向回溯上靠
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfsFind(target, candidates, 0, res, list);
        return res;
    }

    private void dfsFind(int target, int[] candidates, int begin, List<List<Integer>> res, List<Integer> list) {
        // 回溯终止条件
        if (target == 0) {
            ArrayList<Integer> t = new ArrayList<>(list);
            res.add(t);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = begin; i < candidates.length ; i++) {
            int t = target - candidates[i];
            list.add(candidates[i]);
            dfsFind(t, candidates, i, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum39 combinationSum39 = new CombinationSum39();
        combinationSum39.combinationSum(new int[]{2, 3, 6, 7}, 7);

    }


}
