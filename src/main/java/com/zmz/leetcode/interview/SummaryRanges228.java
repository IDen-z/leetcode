package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    // 给定一个  无重复元素 的 有序 整数数组 nums 。
    //
    //返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
    //
    //列表中的每个区间范围 [a,b] 应该按如下格式输出：
    //
    //"a->b" ，如果 a != b
    //"a" ，如果 a == b
    //
    //
    //示例 1：
    //
    //输入：nums = [0,1,2,4,5,7]
    //输出：["0->2","4->5","7"]
    //解释：区间范围是：
    //[0,2] --> "0->2"
    //[4,5] --> "4->5"
    //[7,7] --> "7"
    //示例 2：
    //
    //输入：nums = [0,2,3,4,6,8,9]
    //输出：["0","2->4","6","8->9"]
    //解释：区间范围是：
    //[0,0] --> "0"
    //[2,4] --> "2->4"
    //[6,6] --> "6"
    //[8,9] --> "8->9"


    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        // 也是需要两个指针

        // 记录区间左起点
        int left = 0;
        // 右起点
        int right = 0;
        while (right < nums.length) {
            // 寻找右终点
//            if (right + 1 == nums.length || nums[right] + 1 != nums[right + 1]) {
//                // 区间到达终点 开始记录
//                if (left == right) {
//                    res.add("" + nums[left]);
//                } else {
//                    res.add( nums[left] + "->" +  nums[right]);
//                }
//                right++;
//                left = right;
//            } else {
//                right++;
//            }
            while (right < nums.length - 1 && nums[right] + 1 == nums[right + 1]) {
                right++;
            }
            if (left == right) {
                    res.add("" + nums[left]);
            } else {
                res.add(nums[left] + "->" + nums[right]);
            }
            right++;
            left = right;
        }

        return res;
    }


}
