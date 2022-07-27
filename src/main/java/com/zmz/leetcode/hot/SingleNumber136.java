package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 只出现一次的数字
 */
public class SingleNumber136 {

    /**
     * 只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 使用额外空间
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (list.contains(i)) {
                list.remove((Integer) i);
            } else {
                list.add(i);
            }
        }
        return list.get(0);
    }


    public int singleNumberOff(int[] nums) {

        // 这道题一定要背下来
        // 一个数组中去重 只要对所有数字挨个异或即可
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;

    }


}
