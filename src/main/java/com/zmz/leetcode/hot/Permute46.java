package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Permute46 {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     */
    public List<List<Integer>> permute(int[] nums) {
        // 这种全排列组合的题目 第一反应想到了回溯算法
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res,0,list,nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, int index, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            dfs(res,index+1,list,nums);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Permute46 permute46 = new Permute46();
        permute46.permute(new int[]{1,2,3});
    }

}
