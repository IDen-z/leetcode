package com.zmz.leetcode.tag.sort5;

import java.util.HashSet;

/**
 * 存在重复元素
 */
public class ContainsDuplicate217 {

    /**
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；
     * 如果数组中每个元素互不相同，返回 false 。
     */
    public boolean containsDuplicate(int[] nums) {
        // 第一反应是用hashTable 如果插入失败则返回true
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums){
            if (!set.add(i)){
                return true;
            }
        }
        return false;
    }


}
